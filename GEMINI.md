# Gemini Instructions for SAP PO Extraction

This document outlines the steps for Gemini to perform to extract Java Mappings and UDFs from SAP PO, and organize the extracted files.

**Prerequisites:**
*   Ensure you are running Gemini from a terminal environment that correctly handles file paths with spaces (e.g., a standard `cmd.exe` or PowerShell, not necessarily integrated with VS Code if that caused issues previously).
*   The current working directory for Gemini should be `F:\Desktop\crave\INTEGRATION RELATED\Download-PO`.

**Steps:**

1.  **Run `app.py` to extract Java Mappings:**
    This script will connect to the SAP PO system and download Java Mapping JAR files, saving them directly into the `bytecode/` directory.
    ```
    run_shell_command(command = "python app.py", description = "Running app.py to extract Java Mappings.")
    ```

2.  **Run `udf_extractor.py` to extract UDFs:**
    This script will connect to the SAP PO system and download UDF JAR files, saving them directly into the `bytecode/` directory.
    ```
    run_shell_command(command = "python udf_extractor.py", description = "Running udf_extractor.py to extract UDFs.")
    ```

3.  **Extract Metadata (MANIFEST.MF) from JARs:**
    For each JAR file in the `bytecode/` directory, extract its `META-INF/MANIFEST.MF` file and save it into the `metadata/` directory. Each manifest file will be named after its original JAR file (e.g., `original_jar_name_MANIFEST.MF`).

    *Note: This step requires the `jar` command to be available (part of a Java Development Kit - JDK).*

    ```
    # This part will be executed by Gemini after the above scripts are run.
    # Gemini will list the JARs in 'bytecode/' and then execute commands
    # to extract their manifests.
    ```

4.  **Source Code Extraction (Limitation):**
    Please note that direct extraction of source code (decompilation) from the JAR files is not possible with the current tools. You would need to use an external Java decompiler for this purpose.
