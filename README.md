# SAP PO Java Mapping and UDF Extractor

## Overview

This project provides a set of Python scripts to automate the extraction of Java Mappings and User-Defined Functions (UDFs) from a SAP Process Orchestration (PO) system. It connects to the SAP PO server, retrieves a list of Integration Configurations (ICOs), and then downloads the associated Java Mapping JARs, Function Library data, and their corresponding metadata.

## Features

*   **Java Mapping Extraction:** Downloads the JAR files for Java Mappings used in Operation Mappings.
*   **UDF Extraction:** A comprehensive process to find and extract the source code of User-Defined Functions from both Function Libraries and Message Mappings.
*   **Comprehensive Mapping Search:** The UDF extraction script now searches for mappings in `MAP0`, `REQUEST_TRAFO`, and `RESPONSE_TRAFO` roles to ensure all potential UDFs are found.
*   **Source Code Generation:** The scripts can parse the extracted Function Library data and Message Mapping data to generate human-readable Java source code files for the UDFs.
*   **Metadata Storage:** Saves all the XML responses received from the SAP PO server for each step of the process. This is useful for debugging and for a detailed analysis of the integration objects.
*   **Configurable:** The scripts can be easily configured to connect to different SAP PO environments by changing the connection details in the configuration section of the scripts.

## UDF Extraction Methods

This project has uncovered two distinct methods for extracting User-Defined Functions (UDFs) from SAP PO:

1.  **From Function Libraries:** UDFs can be grouped into Function Libraries. In this case, the `udf_extractor.py` script downloads the Function Library as a zip archive. This archive contains a `metaData.xml` file, which holds the details of the UDFs. The `process_udfs.py` script is then used to parse this XML file and generate the corresponding `.java` source code.

2.  **From Message Mappings:** UDFs can also be embedded directly within a Message Mapping. The `udf_extractor.py` script can identify and extract this embedded code. The script decodes a base64 encoded zip file from the message mapping response, which contains another nested zip file. After unzipping the nested archive, the script reveals the Java source code of the UDF, which is then saved as a `.java` file.

## Workflow

The scripts follow this general workflow:

1.  **Connect to SAP PO:** The scripts establish a connection to the SAP PO system using the provided `BASE_URL`, `CLIENT_ID`, and `CLIENT_SECRET`.
2.  **Fetch ICO List:** They retrieve a list of all Integrated Configurations (ICOs) from the server.
3.  **Traverse Object Hierarchy:** For each ICO, the scripts traverse the hierarchy of related objects to find and extract the desired artifacts.
4.  **Save Artifacts:** All downloaded and extracted files are saved to their respective directories (`bytecode/`, `source-code/`, `metadata/`).

### Java Mapping Extraction Flow (`app.py`)

The `app.py` script performs the following steps to extract Java Mappings:

1.  **Get ICO List:** Fetches the list of all ICOs from the server.
2.  **Get ICO Details:** For each ICO, it fetches the detailed XML configuration.
3.  **Find Operation Mapping:** It parses the ICO XML to find the associated Operation Mapping.
4.  **Get Operation Mapping Details:** It then fetches the detailed XML for the Operation Mapping.
5.  **Find Java Mapping:** The script parses the Operation Mapping XML to find any linked Java Mappings.
6.  **Download Java Mapping:** If a Java Mapping is found, it fetches the content, which is a base64 encoded JAR file.
7.  **Save JAR File:** The script decodes the base64 content and saves the resulting JAR file to the `bytecode/` directory.
8.  **Save Metadata:** All intermediate XML responses are saved to the `metadata/` directory.

### UDF Extraction Flow (`udf_extractor.py` and `process_udfs.py`)

The extraction of User-Defined Functions is a streamlined process that handles both extraction methods:

**Step 1: `udf_extractor.py` - Find and Download UDFs**

1.  **Get ICO List:** Fetches the list of all ICOs from the server.
2.  **Get ICO Details:** For each ICO, it fetches the detailed XML configuration.
3.  **Find Mappings:** It parses the ICO XML to find all associated mappings with roles `MAP0`, `REQUEST_TRAFO`, and `RESPONSE_TRAFO`.
4.  **Get Operation/Message Mapping Details:** It traverses the mapping hierarchy to find the associated Message Mapping.
5.  **Extract UDFs:** The script then automatically handles both UDF extraction methods:
    *   **For Function Libraries:** It finds any linked Function Libraries, downloads the raw data, and extracts the `metaData.xml` file.
    *   **For Message Mappings:** It finds any embedded UDFs, decodes the base64 content, performs a double-unzip, and saves the resulting Java source code.
6.  **Save Metadata:** All intermediate XML responses are saved to the `metadata/` directory.

**Step 2: `process_udfs.py` - Generate UDF Source Code from Function Libraries**

This script is now only needed for UDFs extracted from **Function Libraries**.

1.  **Scan for Raw Data:** This script scans the `source-code` directory for the raw UDF data from Function Libraries (specifically, the directories containing a `metaData.xml` file).
2.  **Parse and Generate Java Code:** The script parses the `metaData.xml` file to get the UDF's package, class name, and Java code. It then constructs a complete, human-readable `.java` file.
3.  **Save Java File:** The final `.java` source file is saved in the same directory where the raw data was found (e.g., `source-code/FuncLib/FuncLib.java`).

**Note on `udf_parser.py`:** The `udf_parser.py` script is an older or alternative version of `process_udfs.py`. For processing Function Libraries, `process_udfs.py` should be used.

## How to Use

### Prerequisites

*   Python 3
*   The `requests` library. You can install it using pip:
    ```bash
    pip install -r requirements.txt
    ```

### Configuration

Before running the scripts, you need to configure the connection details for your SAP PO system. Open `app.py` and `udf_extractor.py` and update the following variables in the configuration section at the top of each file:

```python
# --- Configuration ---
BASE_URL = "http://your-sap-po-host:50000"
CLIENT_ID = "your-client-id"
CLIENT_SECRET = "your-client-secret"
# ---
```

### Running the Scripts

1.  **Extract Java Mappings:**
    To extract the Java Mappings, run the `app.py` script:
    ```bash
    python app.py
    ```

2.  **Extract UDFs:**
    This is now a more streamlined two-step process.
    
    First, run the `udf_extractor.py` script to find and download the raw UDF data from both Function Libraries and Message Mappings:
    ```bash
    python udf_extractor.py
    ```
    
    Second, run the `process_udfs.py` script to generate the Java source code from the Function Library data:
    ```bash
    python process_udfs.py
    ```

### Output

The scripts will create the following directories to store the extracted artifacts:

*   `bytecode/`: Contains the downloaded Java Mapping JAR files.
*   `source-code/`: Contains the extracted UDF source code as `.java` files, from both Function Libraries and Message Mappings.
*   `metadata/`: Contains all the raw XML responses from the SAP PO server, which can be used for debugging and analysis.

## Project Structure

```
.
├── app.py              # Script to extract Java Mappings
├── udf_extractor.py    # Script to find and download UDFs from both Function Libraries and Message Mappings
├── process_udfs.py     # Script to generate UDF source code from Function Libraries
├── udf_parser.py       # (Deprecated) Older version of the UDF parser
├── requirements.txt    # Python package requirements
├── bytecode/           # Output directory for JAR files
├── source-code/        # Output directory for extracted source code
└── metadata/           # Output directory for XML metadata
```