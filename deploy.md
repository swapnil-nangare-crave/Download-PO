# Deployment to SAP Cloud Foundry

This document outlines the steps to deploy the SAP PO Extractor application to SAP Cloud Foundry.

## Prerequisites

*   **SAP Cloud Foundry Account:** Access to an SAP Cloud Foundry subaccount and space.
*   **Cloud Foundry CLI:** The `cf` CLI tool installed and logged in to your target Cloud Foundry endpoint and space.
*   **Buildpacks:** Ensure the `java_buildpack` and `python_buildpack` are available in your Cloud Foundry environment.
*   **Procyon Decompiler JAR:** The `procyon-decompiler-0.6.0.jar` file must be present in the root directory of your application (alongside `app.py` and `udf_extractor.py`).
*   **SAP Cloud Connector (if applicable):** If your SAP PO system is on-premise and not publicly accessible, you will need to have SAP Cloud Connector configured and connected to your Cloud Foundry subaccount to establish a secure tunnel.

## Deployment Steps

1.  **Prepare your Application Directory:**
    Ensure your project directory contains the following files:
    *   `app.py`
    *   `udf_extractor.py`
    *   `requirements.txt`
    *   `manifest.yml` (created by Gemini)
    *   `procyon-decompiler-0.6.0.jar`

2.  **Review `manifest.yml`:**
    The `manifest.yml` file defines your application's deployment parameters. Review its content to ensure it meets your requirements. The `buildpacks` section is crucial for enabling both Java and Python environments.

    ```yaml
    applications:
    - name: sap-po-extractor
      memory: 512M # Adjust as needed based on your usage
      buildpacks:
        - java_buildpack
        - python_buildpack
      command: python app.py # This is the default. You can change it to 'python udf_extractor.py' or a custom script.
      env:
        PYTHONUNBUFFERED: 1
        # BASE_URL, CLIENT_ID, CLIENT_SECRET, JAVA_EXECUTABLE_PATH will be set via cf set-env
    ```

3.  **Push the Application:**
    Navigate to your project's root directory in your terminal and push the application to Cloud Foundry:

    ```bash
    cf push
    ```
    This command will:
    *   Upload your application files.
    *   Detect and apply the specified buildpacks (Java first, then Python).
    *   Stage your application.
    *   Start your application.

4.  **Set Environment Variables:**
    After the application is pushed, you must set the necessary environment variables. These variables are crucial for the application to connect to your SAP PO system and for `app.py` to find the Java executable.

    Replace the placeholder values with your actual SAP PO system details:

    ```bash
    cf set-env sap-po-extractor BASE_URL "http://your-sap-po-host:50000"
    cf set-env sap-po-extractor CLIENT_ID "your-client-id"
    cf set-env sap-po-extractor CLIENT_SECRET "your-client-secret"
    # This is the typical path for the Java executable provided by the Java buildpack in CF.
    # Ensure this path is correct for your specific CF landscape/buildpack version.
    cf set-env sap-po-extractor JAVA_EXECUTABLE_PATH "/home/vcap/app/.java-buildpack/jre/bin/java"
    ```

5.  **Restage the Application:**
    After setting environment variables, you must restage your application for the changes to take effect:

    ```bash
    cf restage sap-po-extractor
    ```

6.  **Verify Application Status:**
    Check the status of your application to ensure it is running:

    ```bash
    cf app sap-po-extractor
    ```

## Running the Application in Cloud Foundry

Once deployed and running, your application will execute the command specified in `manifest.yml` (e.g., `python app.py`). If you need to trigger `udf_extractor.py` or other commands, you can use `cf run-task` or modify the `manifest.yml` command and restage.

Example of running a one-off task:

```bash
cf run-task sap-po-extractor "python udf_extractor.py" --name run-udf-extractor
```

## Troubleshooting

*   **Application Crashes:** Check `cf logs sap-po-extractor --recent` for detailed error messages.
*   **Connection Issues:** Verify your `BASE_URL`, `CLIENT_ID`, `CLIENT_SECRET`, and ensure any necessary Cloud Connector setup is correct and active.
*   **Java/Decompiler Issues:** Confirm `JAVA_EXECUTABLE_PATH` is correct and `procyon-decompiler-0.6.0.jar` is present in the deployed app. Check logs for `java` or `jar` related errors.
