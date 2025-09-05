import requests
import xml.etree.ElementTree as ET
import base64
import os
import html
import zipfile
import io
import re

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

def main():
    """
    Main function to orchestrate the UDF extraction process.
    """
    print("Starting UDF extraction process...")

    # --- ICO Filtering ---
    # Set this to a specific ICO key to process only that one.
    # The key is a '|' separated string. Use '*' for wildcards.
    # Example: "*|*|*|POC_011*"
    target_ico_key_pattern = "" 
    # ---

    # 1. Get ICO List
    ico_list_html = ICO_LIST()
    if not ico_list_html:
        return

    metadata_dir = "metadata"
    if not os.path.exists(metadata_dir):
        os.makedirs(metadata_dir)
    with open(os.path.join(metadata_dir, "ico_list_udf.xml"), "w", encoding="utf-8") as f:
        f.write(ico_list_html)

    if not os.path.exists("output_udf"):
        os.makedirs("output_udf")

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
        
        all_ico_keys = []
        for qref in root.findall('.//qref'):
            key_elem = qref.find('.//key')
            if key_elem is not None:
                key_parts = [elem.text if elem.text is not None else '' for elem in key_elem.findall('.//elem')]
                all_ico_keys.append('|'.join(key_parts))

        if not all_ico_keys:
            print("No ICOs found in the response.")
            return

        print(f"Found {len(all_ico_keys)} ICOs in total.")

        ico_keys_to_process = []
        if target_ico_key_pattern:
            import fnmatch
            for key in all_ico_keys:
                if fnmatch.fnmatch(key, target_ico_key_pattern):
                    ico_keys_to_process.append(key)
            print(f"Filtered to {len(ico_keys_to_process)} ICOs based on pattern: {target_ico_key_pattern}")
        else:
            ico_keys_to_process = all_ico_keys
            print("Processing all ICOs.")


    except (ET.ParseError, AttributeError) as e:
        print(f"Error parsing ICO list XML: {e}")
        return

    # 2. Process each ICO
    for ico_key in ico_keys_to_process:
        print(f"\n--- Processing ICO with key: {ico_key} ---")
        ico_details_xml = ICO_DETAILS(ico_key)
        if not ico_details_xml:
            continue

        ico_key_filename = ico_key.replace('|','_').replace('/','_').replace(':','_').replace('*','_')
        with open(os.path.join("metadata", f"ico_details_{ico_key_filename}.xml"), "w", encoding="utf-8") as f:
            f.write(ico_details_xml)

        try:
            namespaces = {'p1': 'urn:sap-com:xi'}
            ET.register_namespace('p1', 'urn:sap-com:xi')
            ico_root = ET.fromstring(ico_details_xml)
            
            # Find all mapping roles
            map_roles = ico_root.findall(".//p1:lnkRole[@role='MAP0']", namespaces) + \
                        ico_root.findall(".//p1:lnkRole[@role='REQUEST_TRAFO']", namespaces) + \
                        ico_root.findall(".//p1:lnkRole[@role='RESPONSE_TRAFO']", namespaces)

            if not map_roles:
                print("No Operation Mapping, Request, or Response transformations found for this ICO.")
                continue

            for map_role in map_roles:
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

                    om_key_filename = om_key.replace('|','_').replace('/','_').replace(':','_').replace('*','_')
                    with open(os.path.join("metadata", f"om_details_{om_key_filename}.xml"), "w", encoding="utf-8") as f:
                        f.write(om_details_xml)
                    
                    om_root = ET.fromstring(om_details_xml)
                    # Find all message mappings linked in the operation mapping
                    mm_key_elems = om_root.findall(".//p1:key[@typeID='XI_TRAFO']", namespaces)
                    if mm_key_elems:
                        for mm_key_elem in mm_key_elems:
                            mm_elems = mm_key_elem.findall("p1:elem", namespaces)
                            mm_name = mm_elems[0].text
                            mm_namespace = mm_elems[1].text
                            mm_key = f"{mm_name}|{mm_namespace}"
                            print(f"Found Message Mapping: {mm_key}")

                            # 4. Get Message Mapping Details
                            mm_details_xml = MESSAGE_MAPPING_DETAILS(mm_key, swcguid)
                            if not mm_details_xml:
                                continue

                            mm_key_filename = mm_key.replace('|','_').replace('/','_').replace(':','_').replace('*','_')
                            
                            # Save the Message Mapping to its own directory
                            mm_output_dir = "message-mappings"
                            if not os.path.exists(mm_output_dir):
                                os.makedirs(mm_output_dir)

                            mm_file_path = os.path.join(mm_output_dir, f"{mm_key_filename}.xml")
                            with open(mm_file_path, "w", encoding="utf-8") as f:
                                f.write(mm_details_xml)
                            print(f"Saved Message Mapping to {mm_file_path}")

                            # Also save it to metadata for debugging purposes
                            with open(os.path.join("metadata", f"mm_details_{mm_key_filename}.xml"), "w", encoding="utf-8") as f:
                                f.write(mm_details_xml)

                            mm_root = ET.fromstring(mm_details_xml)

                            # --- New logic to extract UDFs from Message Mapping ---
                            try:
                                trafo_ns = {'tr': 'urn:sap-com:xi:mapping:xitrafo'}
                                source_code_blob = mm_root.find('.//tr:SourceCode/tr:blob', trafo_ns)
                                if source_code_blob is not None and source_code_blob.text:
                                    print(f"Found embedded Source Code in Message Mapping: {mm_key}")
                                    zip_content_base64 = source_code_blob.text.replace('!zip!', '')
                                    zip_data = base64.b64decode(zip_content_base64)
                                    
                                    with zipfile.ZipFile(io.BytesIO(zip_data)) as z1:
                                        # Assuming the first zip contains only one file, which is the "first value file" (a zip file)
                                        if len(z1.namelist()) == 1:
                                            first_value_file_name = z1.namelist()[0]
                                            with z1.open(first_value_file_name) as f1:
                                                try:
                                                    with zipfile.ZipFile(io.BytesIO(f1.read())) as z2:
                                                        # Assuming the second zip contains only one file, which is the actual Java code
                                                        if len(z2.namelist()) == 1:
                                                            second_value_file_name = z2.namelist()[0]
                                                            with z2.open(second_value_file_name) as f2:
                                                                # Try different encodings
                                                                inner_file_content = None
                                                                for encoding in ['utf-8', 'latin-1', 'cp1252']:
                                                                    try:
                                                                        inner_file_content = f2.read().decode(encoding)
                                                                        print(f"  Successfully decoded with {encoding}")
                                                                        break
                                                                    except UnicodeDecodeError:
                                                                        f2.seek(0)
                                                                        continue
                                                                
                                                                if inner_file_content is None:
                                                                    print(f"  Error: Could not decode the file with any of the common encodings.")
                                                                    continue

                                                                # Create a directory for the UDFs from this message mapping in output_udf
                                                                udf_output_dir = os.path.join("output_udf", mm_key_filename)
                                                                if not os.path.exists(udf_output_dir):
                                                                    os.makedirs(udf_output_dir)
                                                                
                                                                # Save the raw content of the "second value file" as value.java
                                                                file_path = os.path.join(udf_output_dir, "value.java")
                                                                with open(file_path, "w", encoding="utf-8") as f_out:
                                                                    f_out.write(inner_file_content)
                                                                print(f"  Saved raw Java content to {file_path}")
                                                        else:
                                                            print(f"  Warning: The second zip file contains multiple files. Not sure which one is the 'second value file'.")
                                                            # As a fallback, extract all files to a subfolder
                                                            z2.extractall(os.path.join("output_udf", mm_key_filename, "second_zip_fallback"))
                                                except zipfile.BadZipFile:
                                                    print(f"  Warning: The first value file '{first_value_file_name}' is not a zip file. Skipping further extraction.")
                                        else:
                                            print(f"  Warning: The first zip file contains multiple files. Not sure which one is the 'first value file'.")
                                            # As a fallback, extract all files to a subfolder
                                            z1.extractall(os.path.join("output_udf", mm_key_filename, "first_zip_fallback"))

                            except Exception as e:
                                print(f"Error extracting UDF from message mapping {mm_key}: {e}")
                            # --- End of new logic ---

                            # Assumption: the function library is linked in the message mapping
                            fl_key_elems = mm_root.findall(".//p1:key[@typeID='FUNC_LIB']", namespaces)
                            if fl_key_elems:
                                for fl_key_elem in fl_key_elems:
                                    fl_elems = fl_key_elem.findall("p1:elem", namespaces)
                                    fl_name = fl_elems[0].text
                                    fl_namespace = fl_elems[1].text
                                    fl_key = f"{fl_name}|{fl_namespace}"
                                    print(f"Found Function Library: {fl_key}")

                                    # 5. Get Function Library Details
                                    fl_details_xml = FUNCTION_LIBRARY_DETAILS(fl_key, swcguid)
                                    if not fl_details_xml:
                                        continue

                                    fl_key_filename = fl_key.replace('|','_').replace('/','_').replace(':','_').replace('*','_')
                                    with open(os.path.join("metadata", f"fl_details_{fl_key_filename}.xml"), "w", encoding="utf-8") as f:
                                        f.write(fl_details_xml)

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
                                                # Extract all files to the source-code directory
                                                source_code_dir = "source-code"
                                                if not os.path.exists(source_code_dir):
                                                    os.makedirs(source_code_dir)
                                                
                                                # Create a subdirectory for this function library
                                                fl_dir_name = fl_name.replace('|','_').replace('/','_').replace('*','_')
                                                fl_output_dir = os.path.join(source_code_dir, fl_dir_name)
                                                if not os.path.exists(fl_output_dir):
                                                    os.makedirs(fl_output_dir)

                                                z.extractall(fl_output_dir)
                                                print(f"Extracted all files from function library {fl_name} to {fl_output_dir}")
                                        else:
                                            print(f"Could not find UDF source code in Function Library: {fl_key}")

                                    except (ET.ParseError, zipfile.BadZipFile) as e:
                                        print(f"Error parsing or unzipping Function Library XML: {e}")
                            else:
                                print("No Function Library found for this Message Mapping.")
                    else:
                        print("No Message Mapping found for this Operation Mapping.")
        except ET.ParseError as e:
            print(f"Error parsing XML: {e}")

    print("\nUDF extraction process finished.")

if __name__ == "__main__":
    main()