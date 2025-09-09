# SAP PO Java Mapping and UDF Extractor

## Overview

This project provides a set of Python scripts designed for the automated, efficient, and clean extraction of Java Mappings and User-Defined Functions (UDFs) directly from a SAP Process Orchestration (PO) system. By processing objects entirely in memory, the tools avoid intermediate file clutter and deliver ready-to-use source code in `.zip` archives.

## Features

*   **Direct-to-ZIP Extraction:** All extracted artifacts are processed in memory and saved directly into self-contained `.zip` archives. This ensures a clean project directory and simplifies source code management.
*   **No Intermediate Files:** The entire workflow is optimized to prevent the creation of temporary or intermediate files (such as raw XML responses, bytecode, or partially extracted UDFs). All transformations happen in memory.
*   **Java Mapping Decompilation (`app.py`):
    *   Fetches Java Mapping JARs from the PO system.
    *   Inspects the JAR content in memory.
    *   If `.class` files are present, it decompiles them into human-readable `.java` source code using the Procyon decompiler.
    *   The decompiled `.java` files, along with any other original resources (like `MANIFEST.MF`), are then packaged into a `.zip` archive.
    *   If no `.class` files are found (e.g., it's an empty JAR or only contains resources), the original JAR content is simply re-packaged into a `.zip`.
*   **Comprehensive UDF Extraction (`udf_extractor.py`):** This script handles two distinct types of UDFs:
    *   **Message Mapping UDFs:** Extracts UDFs embedded directly within Message Mappings. This involves a complex multi-stage in-memory decompression and parsing process to retrieve the raw Java code blocks.
    *   **Function Library UDFs:** Extracts UDFs grouped within Function Libraries. This also involves in-memory decompression and XML parsing to generate the corresponding Java source code.
*   **Parallel Processing:** Both `app.py` and `udf_extractor.py` utilize `concurrent.futures.ThreadPoolExecutor` to perform API calls and processing concurrently. This significantly reduces the overall execution time, especially when dealing with a large number of integration objects.
*   **Environment-based Configuration:** Sensitive connection details (like `BASE_URL`, `CLIENT_ID`, `CLIENT_SECRET`, and `JAVA_EXECUTABLE_PATH`) are managed securely via a `.env` file, keeping them out of the main codebase.

## Detailed Extraction Flows

Both `app.py` and `udf_extractor.py` follow a similar high-level pattern:
1.  **Connect to SAP PO:** Establish a secure connection using credentials from the `.env` file.
2.  **Fetch ICO List:** Retrieve a list of all Integrated Configurations (ICOs) from the Integration Directory.
3.  **Parallel Traversal:** Process ICOs concurrently, traversing the object hierarchy (Operation Mappings, Message Mappings, Function Libraries) to identify and extract relevant artifacts.
4.  **In-Memory Processing:** All data blobs (JARs, XMLs, nested zips) are handled in memory without writing intermediate files to disk.
5.  **Direct-to-ZIP Output:** The final, processed source code is written directly into `.zip` archives in the designated output directories.

### Java Mapping Extraction (`app.py`)

This script focuses on extracting Java Mapping programs linked to Operation Mappings:

1.  **Identify Java Mapping:** From the ICO details, it finds associated Operation Mappings (`MAP0` role). From the Operation Mapping details, it identifies linked Java Mapping programs (`MAP_ARCHIVE_PRG` typeID).
2.  **Fetch JAR Blob:** It fetches the Java Mapping content, which is a base64-encoded JAR file blob (`!jar!` prefixed).
3.  **In-Memory Decompilation:** The blob is decoded to raw JAR data. This data is then inspected:
    *   If `.class` files are found, each is extracted to a temporary file, decompiled using `procyon-decompiler-0.6.0.jar`, and the resulting `.java` source is added to a new `.zip` archive.
    *   Other non-`.class` files from the original JAR (e.g., `MANIFEST.MF`) are copied directly to the new `.zip` archive.
    *   If no `.class` files are found, the original JAR content is simply re-zipped.
4.  **Save Archive:** The final `.zip` archive (e.g., `MyJavaMapping.zip`) is saved to the `output/` directory.

### UDF Extraction (`udf_extractor.py`)

This script handles both Message Mapping UDFs and Function Library UDFs, often found linked from Message Mappings (`XI_TRAFO` typeID):

#### Message Mapping UDFs

1.  **Identify Message Mapping:** From the ICO details, it finds Operation Mappings. From Operation Mapping details, it identifies linked Message Mappings.
2.  **Fetch Source Code Blob:** It fetches the Message Mapping details, which may contain an embedded source code blob (`tr:SourceCode/tr:blob`). This blob is base64-encoded and prefixed with `!zip!`.
3.  **Triple-Unzip in Memory:** This is a multi-stage decompression:
    *   The initial blob is decoded to `zip_data` (Zip 1).
    *   Zip 1 is unzipped in memory. It is expected to contain a single file (often named `value`), which is itself a zip archive (Zip 2).
    *   Zip 2 is unzipped in memory. It is expected to contain a single file (often named `value.java`), which holds the raw Java source code for all embedded UDFs within that Message Mapping.
4.  **Parse Java Blocks:** The `value.java` content is parsed using regular expressions to identify and extract individual UDF code blocks (delimited by `// beginning of ...` and `// end of ...` comments).
5.  **Save UDF Archive:** Each extracted UDF code block is saved as a separate `.java` file within a new `.zip` archive (e.g., `MyMessageMappingUDFs.zip`), which is then saved to the `source-code/` directory.

#### Function Library UDFs

1.  **Identify Function Library:** From Message Mapping details, it identifies linked Function Libraries (`FUNC_LIB` typeID).
2.  **Fetch Blob:** It fetches the Function Library details, which contain a base64-encoded blob (`fl:blob`) prefixed with `!zip!`.
3.  **Double-Unzip in Memory:** This is a two-stage decompression:
    *   The initial blob is decoded to `zip_data` (Zip 1).
    *   Zip 1 is unzipped in memory. It is expected to contain a single file (often named `value`), which is itself a zip archive (Zip 2).
    *   Zip 2 is unzipped in memory. It is expected to contain `metaData.xml`, which defines the Function Library's structure and UDFs.
4.  **Generate Java Code:** The `metaData.xml` content is parsed to extract the package, class name, imports, and individual function implementations. This data is then used to construct a complete, human-readable `.java` source file for the entire Function Library.
5.  **Save Archive:** The generated `.java` file is then packaged into a new `.zip` archive (e.g., `MyFunctionLibrary.zip`), which is saved to the `source-code/` directory.

## How to Use

### Prerequisites

*   Python 3 (recommended 3.8+)
*   A Java Development Kit (JDK) installed and configured in your system's PATH, or its full path specified in `.env` (required for `app.py`'s decompilation).
*   Required Python libraries: `requests`, `python-dotenv`. Install them via `pip`:
    ```bash
    pip install -r requirements.txt
    ```

### Configuration

Create a `.env` file in the root of your project directory with the following content. Replace placeholders with your actual SAP PO system details:

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
*   `source-code/`: Contains `.zip` archives of extracted UDFs and Function Libraries. UDF archives contain individual `.java` files for each UDF. Function Library archives contain a single `.java` file representing the entire library.

## Project Structure

```
.
├── .env                # Environment configuration file
├── app.py              # Script for Java Mapping extraction and decompilation
├── udf_extractor.py    # Script for UDF and Function Library extraction
├── requirements.txt    # Python package dependencies
├── output/             # Output directory for Java Mapping archives
└── source-code/        # Output directory for UDF and Function Library archives
```