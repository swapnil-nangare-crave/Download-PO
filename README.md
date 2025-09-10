# SAP PO Java Mapping and UDF Extractor

## Overview

This project provides a set of Python scripts designed for the automated, efficient, and clean extraction of Java Mappings and User-Defined Functions (UDFs) directly from a SAP Process Orchestration (PO) system. By processing objects entirely in memory, the tools eliminate intermediate file clutter and deliver ready-to-use source code in self-contained `.zip` archives. The architecture is optimized for performance through parallel processing and designed for flexible deployment, including on platforms like SAP Cloud Foundry.

## Features

*   **Direct-to-ZIP Extraction:** All extracted artifacts are processed in memory and saved directly into self-contained `.zip` archives. This ensures a clean project directory, simplifies source code management, and streamlines the overall workflow.
*   **No Intermediate Files:** The entire extraction and transformation pipeline operates without writing temporary or intermediate files (such as raw XML responses, bytecode, or partially extracted UDFs) to disk. All data handling, from fetching blobs to final archiving, occurs in memory.
*   **Java Mapping Decompilation (`app.py`):**
    *   **Purpose:** Extracts Java Mapping JARs linked to Operation Mappings.
    *   **Process:** Fetches the base64-encoded JAR blob from the PO system. This blob is decoded to raw JAR data in memory. The script then inspects this in-memory JAR:
        *   **Decompilation:** If `.class` files are found within the JAR, each `.class` file is temporarily written to disk (as required by the decompiler), decompiled into human-readable `.java` source code using the `procyon-decompiler-0.6.0.jar` (a Java-based decompiler executed via `subprocess`). The resulting `.java` source is then added to a new `.zip` archive.
        *   **Resource Inclusion:** Any other non-`.class` files from the original JAR (e.g., `META-INF/MANIFEST.MF`, resource files) are copied directly into the new `.zip` archive.
        *   **Non-Class JARs:** If the original JAR contains no `.class` files, its entire content is simply re-packaged into a `.zip` archive as-is.
    *   **Output:** The final `.zip` archive (e.g., `MyJavaMapping.zip`) is saved to the `output/` directory.
*   **Comprehensive UDF Extraction (`udf_extractor.py`):** This script is designed to extract UDFs from two distinct sources within SAP PO, often found linked from Message Mappings:
    *   **Message Mapping UDFs:**
        *   **Purpose:** Extracts UDFs embedded directly within Message Mappings.
        *   **Process:** Fetches the Message Mapping details, which contain a base64-encoded source code blob (`tr:SourceCode/tr:blob`). This blob is prefixed with `!zip!` and represents a nested, compressed structure.
        *   **Triple-Unzip in Memory:** The script performs a multi-stage decompression:
            1.  The initial blob is base64-decoded to raw `zip_data` (Zip 1).
            2.  Zip 1 is unzipped in memory. It is expected to contain a single file (often named `value`), which is itself a zip archive (Zip 2).
            3.  Zip 2 is unzipped in memory. It is expected to contain a single file (often named `value.java`), which holds the raw Java source code for all embedded UDFs within that specific Message Mapping.
        *   **Java Block Parsing:** The `value.java` content is then parsed using Python's `re` module to identify and extract individual UDF code blocks (delimited by `// beginning of ...` and `// end of ...` comments).
        *   **Output:** Each extracted UDF code block is saved as a separate `.java` file within a new `.zip` archive (e.g., `MyMessageMappingUDFs.zip`), which is then saved to the `output_udf_funclib/` directory.
    *   **Function Library UDFs:**
        *   **Purpose:** Extracts UDFs grouped within Function Libraries.
        *   **Process:** Fetches the Function Library details, which contain a base64-encoded blob (`fl:blob`) prefixed with `!zip!`.
        *   **Double-Unzip in Memory:** This is a two-stage decompression:
            1.  The initial blob is base64-decoded to raw `zip_data` (Zip 1).
            2.  Zip 1 is unzipped in memory. It is expected to contain a single file (named `value`), which is itself a zip archive (Zip 2).
            3.  Zip 2 is unzipped in memory. It is expected to contain `metaData.xml`, which defines the Function Library's structure and UDFs.
        *   **Java Code Generation:** The `metaData.xml` content is parsed using `xml.etree.ElementTree` to extract the package, class name, imports, and individual function implementations. This data is then used to construct a complete, human-readable `.java` source file for the entire Function Library.
        *   **Output:** The generated `.java` file (representing the entire Function Library) is then packaged into a new `.zip` archive (e.g., `MyFunctionLibrary.zip`), which is saved to the `output_udf_funclib/` directory.
*   **Parallel Processing:** Both `app.py` and `udf_extractor.py` leverage Python's `concurrent.futures.ThreadPoolExecutor` to perform API calls and processing concurrently. This significantly reduces the overall execution time by overlapping network latency and I/O operations, especially when dealing with a large number of integration objects.
*   **Environment-based Configuration:** Sensitive connection details (like `BASE_URL`, `CLIENT_ID`, `CLIENT_SECRET`, and `JAVA_EXECUTABLE_PATH`) are managed securely via a `.env` file for local development and directly as environment variables in deployment environments like Cloud Foundry.

## Detailed Extraction Flows

Both `app.py` and `udf_extractor.py` follow a similar high-level pattern:
1.  **Connect to SAP PO:** Establish a secure connection using credentials from the environment.
2.  **Fetch ICO List:** Retrieve a list of all Integrated Configurations (ICOs) from the Integration Directory.
3.  **Parallel Traversal:** Process ICOs concurrently, traversing the object hierarchy (Operation Mappings, Message Mappings, Function Libraries) to identify and extract relevant artifacts.
4.  **In-Memory Processing:** All data blobs (JARs, XMLs, nested zips) are handled in memory without writing intermediate files to disk.
5.  **Direct-to-ZIP Output:** The final, processed source code is written directly into `.zip` archives in the designated output directories.

## How to Use

### Prerequisites

*   Python 3 (recommended 3.8+)
*   A Java Development Kit (JDK) installed and configured in your system's PATH. For `app.py`'s decompilation, the `JAVA_EXECUTABLE_PATH` environment variable must point to your `java.exe` (or `java` on Linux/macOS).
*   Required Python libraries: `requests`, `python-dotenv`. Install them via `pip`:
    ```bash
    pip install -r requirements.txt
    ```

### Configuration

For **local development**, create a `.env` file in the root of your project directory with the following content. Replace placeholders with your actual SAP PO system details:

```dotenv
# SAP PO Connection Details
BASE_URL="http://your-sap-po-host:50000"
CLIENT_ID="your-client-id"
CLIENT_SECRET="your-client-secret"

# Full path to your java.exe for decompilation (used by app.py)
# On Windows, use double backslashes (\\) or forward slashes (/) in the path.
# Example (Windows): JAVA_EXECUTABLE_PATH="C:\\Program Files\\Java\\jdk-11\\bin\\java.exe"
# Example (Linux/macOS): JAVA_EXECUTABLE_PATH="/usr/bin/java"
JAVA_EXECUTABLE_PATH="java" # Default to 'java' if in PATH
```

For **Cloud Foundry deployment**, these variables will be set directly on the platform (see `deploy.md`).

### Running the Scripts

1.  **Extract Java Mappings:**
    To extract and decompile Java Mappings, run `app.py`:
    ```bash
    python app.py
    ```

2.  **Extract UDFs and Function Libraries:**
    To extract all UDFs from Message Mappings and Function Libraries, run `udf_extractor.py`:
    ```bash
    python udf_extractor.py
    ```

### Output

The scripts will automatically create the necessary output directories if they don't already exist:

*   `output/`: Contains `.zip` archives of the processed Java Mappings. Each archive includes decompiled `.java` source code (if `.class` files were present) and other original JAR resources.
*   `output_udf_funclib/`: Contains `.zip` archives of extracted UDFs and Function Libraries. UDF archives contain individual `.java` files for each UDF. Function Library archives contain a single `.java` file representing the entire library.

## Project Structure

```
.
├── .env                # Environment configuration file for local development
├── app.py              # Script for Java Mapping extraction and decompilation
├── udf_extractor.py    # Script for UDF and Function Library extraction
├── requirements.txt    # Python package dependencies
├── output/             # Output directory for Java Mapping archives
├── output_udf_funclib/ # Output directory for UDF and Function Library archives
└── deploy.md           # Deployment instructions for SAP Cloud Foundry
```


## Current Issues
1. VPN connection to PO system needed before running the script
2. JDK Path and Decompiler JAR needed to convert .class files to .java file

### Solutions 
 1. VPN Connection
 -  Problem: The script needs network access to your SAP PO system, which requires a VPN.
 -  Solution: The Python script itself cannot establish a VPN connection. You must ensure that the environment where the script is executed (your machine, a server, a Docker container) has an active VPN connection to the SAP PO network before you run the script. This is an external network prerequisite.

  2. JDK Path and Decompiler JAR
  -   Problem: app.py needs the java.exe executable (from a JDK) and procyon-decompiler-0.6.0.jar to perform decompilation.
  - Solution:
    -   JDK: The JAVA_EXECUTABLE_PATH variable in your .env file must point to the absolute path of a Java Development Kit (JDK) installation on the machine where the script will run.
    -   Decompiler JAR: The procyon-decompiler-0.6.0.jar file must be present in the same directory as app.py (or its path adjusted in app.py).