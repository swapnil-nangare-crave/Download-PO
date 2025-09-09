# **SAP PO Artifact Extraction Toolkit - Functional Design**

### **Functionality Status**

| Functionality | Status |
| :--- | :--- |
| System Configuration | Complete |
| Java Mapping Extraction | Complete |
| UDF and Function Library Extraction | Complete |
| UDF Source Code Generation | Complete |
| Full UDF Extraction Orchestration | Complete |
| Java Source Decompilation | Not Supported |

### **Desired Functionality**

This toolkit aims to automate the end-to-end extraction process for custom Java code (Java Mappings and UDFs) from a SAP PO system. The goal is to provide developers with local, analyzable source files and compiled archives, facilitating code reviews, documentation, and migration assessments.

---

### **Functional Requirements**

Each script in the toolkit corresponds to a backend process. Below are the detailed functional requirements:

#### **FR-01: System Configuration**

*   **Description:** A `.env` file must be configured with the target SAP PO system's URL and authentication credentials before any extraction scripts can be run.
*   **Inputs Required:**
    *   `BASE_URL`: The root URL of the SAP PO system (e.g., `http://hostname:50000`).
    *   `CLIENT_ID`: The username for API authentication.
    *   `CLIENT_SECRET`: The password for API authentication.
*   **Validation:** All three fields are mandatory. The scripts will fail to execute and will print an error message if these values are missing.
*   **Usage:** These credentials are used to authenticate all API calls to the SAP PO Directory and Repository services.

---

#### **FR-02: Java Mapping Extraction (`app.py`)**

*   **Description:** This function executes a script (`app.py`) to connect to the SAP PO system, iterate through all Integration Configurations (ICOs), find any associated Java Mappings, and download them as compiled `.jar` files.
*   **Behavior:**
    1.  The user executes the command `python app.py`.
    2.  The script provides real-time console output, logging the ICOs it is currently processing.
    3.  For each ICO, it traverses the object hierarchy (ICO -> Operation Mapping -> Java Mapping).
    4.  On finding a Java Mapping, it decodes the Base64 content from the API response.
*   **Output Usage:**
    *   The primary output is the set of compiled `.jar` files, which are saved in the `bytecode/` directory. These archives contain the executable Java Mapping code.
    *   All intermediate API responses (in XML format) are saved to the `metadata/` directory for debugging and manual inspection.

---

#### **FR-03: UDF and Function Library Extraction (`udf_extractor.py`)**

*   **Description:** This function executes a script (`udf_extractor.py`) to find and download the raw data for User-Defined Functions (UDFs). It handles two distinct sources: UDFs embedded directly within a Message Mapping and UDFs contained within reusable Function Libraries.
*   **Behavior:**
    1.  The user executes the command `python udf_extractor.py`.
    2.  The script traverses all ICOs and their related mappings (`MAP0`, `REQUEST_TRAFO`, `RESPONSE_TRAFO`).
    3.  It automatically detects the UDF source and performs the correct extraction method.
*   **Extraction Methods:**
    *   **Embedded UDFs:** Decodes a Base64 blob from the Message Mapping XML, performs a "triple-unzip" (ZIP -> ZIP -> Java file), and saves the raw Java content.
    *   **Function Libraries:** Decodes a Base64 blob from the Function Library XML and extracts the contents of the resulting ZIP archive, which includes a `metaData.xml` file.
*   **Output Usage:**
    *   Raw Java content for embedded UDFs is saved to subdirectories within `output_udf/`.
    *   Extracted Function Library files are saved to subdirectories within `source-code/`.
    *   The complete XML definition of every discovered Message Mapping is saved to the `message-mappings/` directory.

---

#### **FR-04: UDF Source Code Generation**

*   **Description:** This function processes the raw data extracted by `udf_extractor.py` (FR-03) to generate human-readable, well-structured `.java` source files.
*   **Behavior:** This is a two-part process that the user runs after completing FR-03.
    1.  **For Embedded UDFs (`parse_java_blocks.py`):** The script scans the `output_udf/` directory. It parses the raw `value.java` files and intelligently splits the content into separate files for each individual function, using code comments as delimiters.
    2.  **For Function Libraries (`process_udfs.py`):** The script scans the `source-code/` directory for `metaData.xml` files. It parses the XML to reconstruct a complete Java class file, including package, imports, and all function definitions for that library.
*   **Validation:**
    *   The scripts depend on the directory structure and files created by `udf_extractor.py`.
    *   If input files are missing or malformed, the scripts will report an error.
*   **Output:** Formatted `.java` files are created and organized within the `output_udf/` and `source-code/` directories, respectively.

---

#### **FR-05: Full UDF Extraction Orchestration (`run_all.py`)**

*   **Description:** This function provides a single, convenient command (`run_all.py`) to execute the entire UDF and Function Library workflow, combining the extraction (FR-03) and source code generation (FR-04) steps.
*   **Behavior:**
    1.  The user executes the command `python run_all.py`.
    2.  The script sequentially invokes the logic to find, download, and process UDFs from all sources.
    3.  Console output indicates the progress of each sub-task.
*   **Validation:** Requires the System Configuration (FR-01) to be complete.
*   **Output:** Populates the `output_udf/`, `source-code/`, and `message-mappings/` directories with the final, processed source code and metadata.
*   **Note:** This orchestration script is focused solely on UDFs and does **not** perform the Java Mapping Extraction (`app.py`).

---

#### **FR-06: Java Source Decompilation**

*   **Description:** The process of converting the compiled Java Mapping `.jar` files (the output of FR-02) back into readable `.java` source code.
*   **Status:** **Not Supported**
*   **Behavior:** This is a manual step that must be performed by the user outside of this toolkit. It requires a third-party Java decompiler.
*   **Provided Tool:** The `procyon-decompiler-0.6.0.jar` file is included in the project root and can be used from the command line for this purpose. Example command:
    ```bash
    java -jar procyon-decompiler-0.6.0.jar -jar "bytecode/your_mapping_file.jar" -o "source-code/decompiled_mapping"
    ```