import requests
import xml.etree.ElementTree as ET
import base64
import os
import html
import zipfile
import io

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

def MESSAGE_MAPPING_DETAILS(key, swcguid):
    """
    Fetches the details for a specific Message Mapping.
    """
    url = f"{BASE_URL}/rep/read/ext"
    params = {
        "method": "PLAIN",
        "TYPE": "XI_TRAFO",
        "KEY": key,
        "VC": "SWC",
        "SWCGUID": swcguid,
        "SP": "-1",
        "UC": "true",
        "release": "7.0"
    }
    try:
        response = requests.post(url, params=params, auth=get_auth())
        response.raise_for_status()
        return response.text
    except requests.exceptions.RequestException as e:
        print(f"Error fetching Message Mapping details: {e}")
        return None

def FUNCTION_LIBRARY_DETAILS(key, swcguid):
    """
    Fetches the details for a specific Function Library.
    """
    url = f"{BASE_URL}/rep/read/ext"
    params = {
        "method": "PLAIN",
        "TYPE": "FUNC_LIB",
        "KEY": key,
        "VC": "SWC",
        "SWCGUID": swcguid,
        "SP": "-1",
        "UC": "true",
        "release": "7.0"
    }
    try:
        response = requests.post(url, params=params, auth=get_auth())
        response.raise_for_status()
        return response.text
    except requests.exceptions.RequestException as e:
        print(f"Error fetching Function Library details: {e}")
        return None

def save_udf_code(udf_code, output_dir="output_udf", filename="udf.java"):
    """
    Saves the UDF code to a file.
    """
    try:
        if not os.path.exists(output_dir):
            os.makedirs(output_dir)
        file_path = os.path.join(output_dir, filename)
        with open(file_path, "w", encoding="utf-8") as f:
            f.write(udf_code)
        print(f"Successfully saved UDF code to {file_path}")
        return file_path
    except Exception as e:
        print(f"Error saving UDF code: {e}")
        return None

def main():
    """
    Main function to orchestrate the UDF extraction process.
    """
    print("Starting UDF extraction process...")

    # 1. Get ICO List
    ico_list_html = ICO_LIST()
    if not ico_list_html:
        return

    try:
        start_tag = '<textarea name="response" cols="50" rows="10" readonly>'
        end_tag = '</textarea>'
        start_index = ico_list_html.find(start_tag)
        if start_index == -1:
            raise AttributeError("Could not find the start of the response textarea.")
        
        start_index += len(start_tag)
        end_index = ico_list_html.find(end_tag, start_index)
        if end_index == -1:
            raise AttributeError("Could not find the end of the response textarea.")

        xml_string = ico_list_html[start_index:end_index].strip()
        xml_string = html.unescape(xml_string)
        root = ET.fromstring(xml_string)
        
        ico_keys = []
        for qref in root.findall('.//qref'):
            key_elem = qref.find('.//key')
            if key_elem is not None:
                key_parts = [elem.text if elem.text is not None else '' for elem in key_elem.findall('.//elem')]
                ico_keys.append('|'.join(key_parts))

        if not ico_keys:
            print("No ICOs found in the response.")
            return

        print(f"Found {len(ico_keys)} ICOs.")

    except (ET.ParseError, AttributeError) as e:
        print(f"Error parsing ICO list XML: {e}")
        return

    # 2. Process each ICO
    for ico_key in ico_keys:
        print(f"\n--- Processing ICO with key: {ico_key} ---")
        ico_details_xml = ICO_DETAILS(ico_key)
        if not ico_details_xml:
            continue

        try:
            namespaces = {'p1': 'urn:sap-com:xi'}
            ET.register_namespace('p1', 'urn:sap-com:xi')
            ico_root = ET.fromstring(ico_details_xml)
            map_role = ico_root.find(".//p1:lnkRole[@role='MAP0']", namespaces)
            if map_role is not None:
                om_key_elem = map_role.find(".//p1:key[@typeID='MAPPING']", namespaces)
                if om_key_elem is not None:
                    elems = om_key_elem.findall("p1:elem", namespaces)
                    om_name = elems[0].text
                    om_namespace = elems[1].text
                    om_key = f"{om_name}|{om_namespace}"

                    vc_elem = map_role.find(".//p1:vc", namespaces)
                    swcguid = vc_elem.get('swcGuid')

                    print(f"Found Operation Mapping: {om_key} with SWCGUID: {swcguid}")

                    # 3. Get Operation Mapping Details
                    om_details_xml = OPERATION_MAPPING_DETAILS(om_key, swcguid)
                    if not om_details_xml:
                        continue
                    
                    om_root = ET.fromstring(om_details_xml)
                    # Assumption: the message mapping is linked in the operation mapping
                    mm_key_elem = om_root.find(".//p1:key[@typeID='XI_TRAFO']", namespaces)
                    if mm_key_elem is not None:
                        mm_elems = mm_key_elem.findall("p1:elem", namespaces)
                        mm_name = mm_elems[0].text
                        mm_namespace = mm_elems[1].text
                        mm_key = f"{mm_name}|{mm_namespace}"
                        print(f"Found Message Mapping: {mm_key}")

                        # 4. Get Message Mapping Details
                        mm_details_xml = MESSAGE_MAPPING_DETAILS(mm_key, swcguid)
                        if not mm_details_xml:
                            continue

                        mm_root = ET.fromstring(mm_details_xml)
                        # Assumption: the function library is linked in the message mapping
                        fl_key_elem = mm_root.find(".//p1:key[@typeID='FUNC_LIB']", namespaces)
                        if fl_key_elem is not None:
                            fl_elems = fl_key_elem.findall("p1:elem", namespaces)
                            fl_name = fl_elems[0].text
                            fl_namespace = fl_elems[1].text
                            fl_key = f"{fl_name}|{fl_namespace}"
                            print(f"Found Function Library: {fl_key}")

                            # 5. Get Function Library Details
                            fl_details_xml = FUNCTION_LIBRARY_DETAILS(fl_key, swcguid)
                            if not fl_details_xml:
                                continue

                            # 6. Extract UDF code from Function Library XML
                            try:
                                fl_root = ET.fromstring(fl_details_xml)
                                fl_ns = {'fl': 'urn:sap-com:xi:flib'}
                                blob_elem = fl_root.find('.//fl:blob', fl_ns)
                                
                                if blob_elem is not None and blob_elem.text:
                                    # Remove the '!zip!' prefix and decode the base64 content
                                    zip_content_base64 = blob_elem.text.replace('!zip!', '')
                                    
                                    zip_data = base64.b64decode(zip_content_base64)
                                    
                                    # Unzip the content in memory
                                    with zipfile.ZipFile(io.BytesIO(zip_data)) as z:
                                        
                                        # Assuming the first file in the zip is the source
                                        for filename in z.namelist():
                                            if filename == 'value': # Assuming 'value' is the binary JAR
                                                with z.open(filename, 'r') as f:
                                                    udf_binary_content = f.read()
                                                    output_filename = f"{fl_name.replace('|','_').replace('/','_')}.jar" # Save as JAR
                                                    
                                                    # Save the binary content to a file
                                                    output_dir="output_udf"
                                                    if not os.path.exists(output_dir):
                                                        os.makedirs(output_dir)
                                                    file_path = os.path.join(output_dir, output_filename)
                                                    with open(file_path, "wb") as out_f:
                                                        out_f.write(udf_binary_content)
                                                    print(f"Successfully saved UDF JAR file to {file_path}")
                                                    # Removed break to extract all UDFs in a Function Library
                                else:
                                    print(f"Could not find UDF source code in Function Library: {fl_key}")

                            except (ET.ParseError, zipfile.BadZipFile) as e:
                                print(f"Error parsing or unzipping Function Library XML: {e}")

                        else:
                            print("No Function Library found for this Message Mapping.")
                    else:
                        print("No Message Mapping found for this Operation Mapping.")
            else:
                print("No Operation Mapping found for this ICO.")
        except ET.ParseError as e:
            print(f"Error parsing XML: {e}")

    print("\nUDF extraction process finished.")

if __name__ == "__main__":
    main()

