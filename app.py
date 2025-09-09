import requests
import xml.etree.ElementTree as ET
import base64
import os
import html
import subprocess
import zipfile
import io
import tempfile

# --- Configuration ---
from dotenv import load_dotenv
load_dotenv( dotenv_path=".env", override=True)

BASE_URL = os.getenv("BASE_URL")
CLIENT_ID = os.getenv("CLIENT_ID")
CLIENT_SECRET = os.getenv("CLIENT_SECRET")
JAVA_EXECUTABLE_PATH = os.getenv("JAVA_EXECUTABLE_PATH", "java")
print(f"--- Using Java executable path: {JAVA_EXECUTABLE_PATH} ---")
# ---

def get_auth():
    return (CLIENT_ID, CLIENT_SECRET)

def ICO_LIST():
    """
    Fetches the list of ICOs (Integration Configurations).
    """
    url = f"{BASE_URL}/dir/support/SimpleQuery"
    params = {
        "qc": "Default (for directory objects)",
        "businessL": "Business_sys_ASJava",
        "syncTabL": "true",
        "deletedL": "N",
        "xmlReleaseL": "7.1",
        "responseXMLL": "true",
        "types": "AllInOne",
        "result": "RA_XILINK",
        "action": "Start query"
    }
    try:
        response = requests.post(url, params=params, auth=get_auth())
        response.raise_for_status()  # Raise an exception for bad status codes
        return response.text
    except requests.exceptions.RequestException as e:
        print(f"Error fetching ICO list: {e}")
        return None

def ICO_DETAILS(ico_key):
    """
    Fetches the details for a specific ICO.
    """
    url = f"{BASE_URL}/dir/read/ext"
    params = {
        "method": "PLAIN",
        "TYPE": "AllInOne",
        "KEY": ico_key,
        "VC": "DIR",
        "UC": "false",
        "release": "7.0"
    }
    try:
        response = requests.post(url, params=params, auth=get_auth())
        response.raise_for_status()
        return response.text
    except requests.exceptions.RequestException as e:
        print(f"Error fetching ICO details for key {ico_key}: {e}")
        return None

def OPERATION_MAPPING_DETAILS(key, swcguid):
    """
    Fetches the details for a specific Operation Mapping.
    """
    url = f"{BASE_URL}/rep/read/ext"
    params = {
        "method": "PLAIN",
        "TYPE": "MAPPING",
        "KEY": key,
        "VC": "SWC",
        "SWCGUID": swcguid,
        "SP": "-1",
        "UC": "false",
        "release": "7.0"
    }
    try:
        response = requests.post(url, params=params, auth=get_auth())
        response.raise_for_status()
        return response.text
    except requests.exceptions.RequestException as e:
        print(f"Error fetching Operation Mapping details: {e}")
        return None

def JAVA_MAPPING(key, swcguid):
    """
    Fetches the Java Mapping (JAR file).
    """
    url = f"{BASE_URL}/rep/read/ext"
    params = {
        "method": "PLAIN",
        "TYPE": "TRAFO_JAR",
        "KEY": key,
        "VC": "SWC",
        "SWCGUID": swcguid,
        "UC": "true",
        "release": "7.0"
    }
    try:
        response = requests.post(url, params=params, auth=get_auth())
        response.raise_for_status()
        return response.text
    except requests.exceptions.RequestException as e:
        print(f"Error fetching Java Mapping: {e}")
        return None

def process_and_save_mapping(jar_data, filename_base, output_dir="output"):
    """
    Processes a Java Mapping JAR from memory.
    - If it contains .class files, it decompiles them and creates a ZIP archive
      in the output directory containing the .java source and other resources.
    - If it contains no .class files, it saves the original JAR as a ZIP file.
    """
    if not os.path.exists(output_dir):
        os.makedirs(output_dir)

    output_zip_path = os.path.join(output_dir, f"{filename_base}.zip")

    try:
        with zipfile.ZipFile(io.BytesIO(jar_data)) as jar_file:
            class_files = [f for f in jar_file.namelist() if f.endswith('.class')]

            if not class_files:
                print(f"  No .class files found. Saving original JAR as {output_zip_path}")
                with open(output_zip_path, "wb") as f:
                    f.write(jar_data)
                return

            print(f"  Found {len(class_files)} .class file(s). Decompiling and creating ZIP archive...")

            with zipfile.ZipFile(output_zip_path, 'w', zipfile.ZIP_DEFLATED) as output_zip:
                for member in jar_file.infolist():
                    print(f"    Processing member: {member.filename}")
                    if member.filename.endswith('.class'):
                        print(f"      Found .class file. Attempting to decompile...")
                        with tempfile.NamedTemporaryFile(delete=False, suffix='.class') as temp_class_file:
                            temp_class_file.write(jar_file.read(member.filename))
                            temp_class_path = temp_class_file.name

                        try:
                            proc = subprocess.run(
                                [JAVA_EXECUTABLE_PATH, '-jar', 'procyon-decompiler-0.6.0.jar', temp_class_path],
                                capture_output=True, text=True, encoding='utf-8', errors='ignore'
                            )

                            if proc.stderr:
                                print(f"      Decompiler stderr:\n---\n{proc.stderr}\n---")

                            if proc.returncode == 0 and proc.stdout:
                                java_source = proc.stdout
                                java_filename = member.filename.replace('.class', '.java')
                                output_zip.writestr(java_filename, java_source)
                                print(f"      SUCCESS: Decompiled and added {java_filename}")
                            else:
                                print(f"      FAILURE: Decompilation failed or produced no output for {member.filename}. Adding original .class file to ZIP.")
                                output_zip.writestr(member.filename, jar_file.read(member.filename))
                        finally:
                            os.unlink(temp_class_path)
                    else:
                        print(f"      Not a .class file. Copying directly.")
                        output_zip.writestr(member.filename, jar_file.read(member.filename))

            print(f"  Successfully created source archive: {output_zip_path}")

    except zipfile.BadZipFile:
        print(f"  Error: Bad JAR/ZIP file. Saving original file as {output_zip_path}")
        with open(output_zip_path, "wb") as f:
            f.write(jar_data)
    except Exception as e:
        print(f"  An error occurred while processing the JAR file: {e}")

def main():
    """
    Main function to orchestrate the download process.
    """
    print("Starting Java Mapping extraction and processing...")

    # 1. Get ICO List
    ico_list_html = ICO_LIST()
    if not ico_list_html:
        return

    # 2. Parse ICO List XML from HTML response
    try:
        start_tag = '<textarea name="response" cols="50" rows="10" readonly>'
        end_tag = '</textarea>'
        start_index = ico_list_html.find(start_tag) + len(start_tag)
        end_index = ico_list_html.find(end_tag, start_index)
        xml_string = html.unescape(ico_list_html[start_index:end_index].strip())
        root = ET.fromstring(xml_string)

        ico_keys = ['|'.join(elem.text or '' for elem in key_elem.findall('.//elem')) for key_elem in root.findall('.//qref/.//key')]
        print(f"Found {len(ico_keys)} ICOs to process.")

    except Exception as e:
        print(f"Error parsing ICO list XML: {e}")
        return

    # 3. Process each ICO
    for ico_key in ico_keys:
        print(f"\n--- Processing ICO: {ico_key} ---")
        ico_details_xml = ICO_DETAILS(ico_key)
        if not ico_details_xml:
            continue

        try:
            namespaces = {'p1': 'urn:sap-com:xi'}
            ico_root = ET.fromstring(ico_details_xml)
            map_role = ico_root.find(".//p1:lnkRole[@role='MAP0']", namespaces)

            if map_role is not None:
                om_key_elem = map_role.find(".//p1:key[@typeID='MAPPING']", namespaces)
                if om_key_elem is not None:
                    elems = om_key_elem.findall("p1:elem", namespaces)
                    om_name, om_namespace = elems[0].text, elems[1].text
                    om_key = f"{om_name}|{om_namespace}"
                    swcguid = map_role.find(".//p1:vc", namespaces).get('swcGuid')
                    print(f"  Found Operation Mapping: {om_key}")

                    om_details_xml = OPERATION_MAPPING_DETAILS(om_key, swcguid)
                    if not om_details_xml:
                        continue

                    om_root = ET.fromstring(om_details_xml)
                    java_mapping_key = om_root.find(".//p1:key[@typeID='MAP_ARCHIVE_PRG']", namespaces)
                    if java_mapping_key is not None:
                        java_mapping_name = java_mapping_key.find(".//p1:elem[1]", namespaces).text
                        java_mapping_namespace = java_mapping_key.find(".//p1:elem[2]", namespaces).text
                        java_mapping_full_key = f"{java_mapping_name}|{java_mapping_namespace}"
                        print(f"    Found Java Mapping: {java_mapping_full_key}")

                        java_mapping_xml = JAVA_MAPPING(java_mapping_full_key, swcguid)
                        if not java_mapping_xml:
                            continue

                        java_mapping_root = ET.fromstring(java_mapping_xml)
                        archive_ns = {'ar': 'urn:sap-com:xi:mapping:archive'}
                        blob_element = java_mapping_root.find(".//ar:blob", archive_ns)

                        if blob_element is not None and blob_element.text:
                            jar_content_base64 = blob_element.text.replace('!jar!', '')
                            jar_data = base64.b64decode(jar_content_base64)

                            # Process and save the mapping
                            filename_base = f"{ico_key.replace('|','_').replace('/','_').replace(':','_').replace('*','_')}_{om_name}"
                            process_and_save_mapping(jar_data, filename_base)
                        else:
                            print("    Could not find blob content in the Java Mapping response.")
                    else:
                        print("  No Java Mapping found for this Operation Mapping.")
            else:
                print("  No Operation Mapping found for this ICO.")
        except Exception as e:
            print(f"  Error parsing details for ICO {ico_key}: {e}")

    print("\nExtraction process finished.")

if __name__ == "__main__":
    if not CLIENT_ID or not CLIENT_SECRET:
        print("Please enter your CLIENT_ID and CLIENT_SECRET in the script.")
    else:
        main()
