import requests
import xml.etree.ElementTree as ET
import base64
import os

import html

# --- Configuration ---
BASE_URL = "http://192.168.1.118:50000"
CLIENT_ID = "SAC_Swapnil"
CLIENT_SECRET = "Pass@111"
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

def extract_java_code(jar_content_base64, output_dir="output", filename="mapping.jar"):
    """
    Decodes the Base64 JAR content and saves it to a file.
    """
    try:
        jar_data = base64.b64decode(jar_content_base64)
        if not os.path.exists(output_dir):
            os.makedirs(output_dir)
        file_path = os.path.join(output_dir, filename)
        with open(file_path, "wb") as f:
            f.write(jar_data)
        print(f"Successfully saved JAR file to {file_path}")
        return file_path
    except Exception as e:
        print(f"Error decoding/saving JAR file: {e}")
        return None

def main():
    """
    Main function to orchestrate the download process.
    """
    print("Starting Java Mapping extraction process...")

    # 1. Get ICO List
    ico_list_xml = ICO_LIST()
    if not ico_list_xml:
        return

    # Save the XML to a file for debugging
    with open("ico_list.xml", "w", encoding="utf-8") as f:
        f.write(ico_list_xml)
    print("Saved ICO list response to ico_list.xml")

    # 2. Parse ICO List XML from HTML response
    try:
        # The response is HTML. We will extract the XML from the textarea using string manipulation.
        start_tag = '<textarea name="response" cols="50" rows="10" readonly>'
        end_tag = '</textarea>'
        start_index = ico_list_xml.find(start_tag)
        if start_index == -1:
            raise AttributeError("Could not find the start of the response textarea.")
        
        start_index += len(start_tag)
        end_index = ico_list_xml.find(end_tag, start_index)
        if end_index == -1:
            raise AttributeError("Could not find the end of the response textarea.")

        print(f"Start index: {start_index}")
        print(f"End index: {end_index}")

        xml_string = ico_list_xml[start_index:end_index].strip()
        xml_string = html.unescape(xml_string)

        print(f"Length of extracted string: {len(xml_string)}")
        print(f"Representation of extracted string: {repr(xml_string)}")

        # Print the extracted XML string for debugging
        print("\n--- Extracted XML String ---")
        print(xml_string)
        print("--------------------------\n")

        # Now parse the extracted XML string
        root = ET.fromstring(xml_string)
        
        # IMPORTANT: The following line assumes the ICO keys are found in <qref>...<key>
        # Please inspect the XML output and adjust the findall path if needed.
        ico_keys = []
        for qref in root.findall('.//qref'):
            key_elem = qref.find('.//key')
            if key_elem is not None:
                # Reconstruct the key from the elem tags
                key_parts = [elem.text if elem.text is not None else '' for elem in key_elem.findall('.//elem')]
                ico_keys.append('|'.join(key_parts))

        if not ico_keys:
            print("No ICOs found in the response.")
            return

        print(f"Found {len(ico_keys)} ICOs.")

    except (ET.ParseError, AttributeError) as e:
        print(f"Error parsing ICO list XML: {e}")
        return

    # 3. Process each ICO
    for ico_key in ico_keys:
        print(f"\n--- Processing ICO with key: {ico_key} ---")
        ico_details_xml = ICO_DETAILS(ico_key)
        if not ico_details_xml:
            continue

        try:
            # Correct namespace for the ICO details XML
            namespaces = {'p1': 'urn:sap-com:xi'}
            ico_root = ET.fromstring(ico_details_xml)

            # Find Operation Mapping details
            map_role = ico_root.find(".//p1:lnkRole[@role='MAP0']", namespaces)
            if map_role is not None:
                # Extract OM name and namespace
                om_key_elem = map_role.find(".//p1:key[@typeID='MAPPING']", namespaces)
                if om_key_elem is not None:
                    elems = om_key_elem.findall("p1:elem", namespaces)
                    om_name = elems[0].text
                    om_namespace = elems[1].text
                    om_key = f"{om_name}|{om_namespace}"

                    # Extract swcGuid
                    vc_elem = map_role.find(".//p1:vc", namespaces)
                    swcguid = vc_elem.get('swcGuid')

                    print(f"Found Operation Mapping: {om_key} with SWCGUID: {swcguid}")

                    # 4. Get Operation Mapping Details
                    om_details_xml = OPERATION_MAPPING_DETAILS(om_key, swcguid)
                    if not om_details_xml:
                        continue

                    om_root = ET.fromstring(om_details_xml)
                    # Check for Java Mapping
                    java_mapping_key = om_root.find(".//p1:key[@typeID='MAP_ARCHIVE_PRG']", namespaces)
                    if java_mapping_key is not None:
                        java_mapping_name = java_mapping_key.find(".//p1:elem[1]", namespaces).text
                        java_mapping_namespace = java_mapping_key.find(".//p1:elem[2]", namespaces).text
                        java_mapping_full_key = f"{java_mapping_name}|{java_mapping_namespace}"
                        
                        print(f"Found Java Mapping: {java_mapping_full_key}")

                        # 5. Download Java Mapping
                        java_mapping_xml = JAVA_MAPPING(java_mapping_full_key, swcguid)
                        if not java_mapping_xml:
                            continue

                        java_mapping_root = ET.fromstring(java_mapping_xml)
                        # Correct namespace for the archive
                        archive_ns = {'ar': 'urn:sap-com:xi:mapping:archive'}
                        blob_element = java_mapping_root.find(".//ar:blob", archive_ns)
                        
                        if blob_element is not None and blob_element.text:
                            # Remove the '!jar!' prefix and decode the base64 content
                            jar_content_base64 = blob_element.text.replace('!jar!', '')
                            # Use ICO key and OM name for a more descriptive filename
                            filename = f"{ico_key.replace('|','_').replace('/','_').replace(':','_')}_{om_name}.jar"
                            extract_java_code(jar_content_base64, filename=filename)
                        else:
                            print("Could not find blob content in the response.")

                    else:
                        print("No Java Mapping found for this Operation Mapping.")
            else:
                print("No Operation Mapping found for this ICO.")
        except ET.ParseError as e:
            print(f"Error parsing ICO details XML: {e}")

    print("\nExtraction process finished.")

if __name__ == "__main__":
    if not CLIENT_ID or not CLIENT_SECRET:
        print("Please enter your CLIENT_ID and CLIENT_SECRET in the script.")
    else:
        main()