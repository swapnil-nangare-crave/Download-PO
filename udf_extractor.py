import requests
import xml.etree.ElementTree as ET
import base64
import os
import html
import zipfile
import io
import re

# --- Configuration ---
from dotenv import load_dotenv
load_dotenv( dotenv_path=".env", override=True)

BASE_URL = os.getenv("BASE_URL")
CLIENT_ID = os.getenv("CLIENT_ID")
CLIENT_SECRET = os.getenv("CLIENT_SECRET")
# ---

#==============================================================================
# HELPER FUNCTIONS (Consolidated from other scripts)
#==============================================================================

def parse_udfs_from_java_content(java_content):
    """
    Parses a string containing raw Java code from a message mapping, 
    extracts individual UDF blocks, and returns them in a dictionary.
    """
    extracted_blocks = {}
    lines = java_content.splitlines()
    in_block = False
    # Blocks like 'import' are not real UDFs, so we skip them.
    skipping_blocks = ['init', 'import', 'cleanUp', 'attributes']
    current_block_name = None
    current_block_code = []
    
    for line in lines:
        start_match = re.search(r'// beginning of (.+?)\s+[a-f0-9]+', line)
        end_match = re.search(r'// end of (.+?)\s+[a-f0-9]+', line)
        
        if start_match:
            in_block = True
            current_block_name = start_match.group(1).strip()
            if current_block_name in skipping_blocks:
                in_block = False
                continue
            current_block_code = []
        elif end_match and in_block:
            in_block = False
            # Sanitize the block name to be a valid Java class name
            file_name = f"{current_block_name}.java"
            extracted_blocks[file_name] = "\n".join(current_block_code)
            print(f"    Extracted UDF block: '{current_block_name}'")
            current_block_code = []
        elif in_block:
            current_block_code.append(line)
            
    return extracted_blocks

def generate_java_from_funclib_xml(xml_content):
    """
    Parses the metaData.xml from a Function Library, extracts UDF information,
    and returns the class name and generated Java code.
    """
    try:
        root = ET.fromstring(xml_content)
        package_name = root.find('package').text
        class_name = root.find('classname').text
        imports = root.find('imports').text

        java_code = f"package {package_name};\n\n"
        java_code += imports + "\n"
        java_code += f"public class {class_name} {{\n\n"

        for function in root.findall('functionmodel'):
            function_name = function.find('name').text
            args = []
            for arg in function.findall('signature/argument'):
                arg_type = arg.get('jtp')
                arg_name = arg.get('nm')
                args.append(f"{arg_type} {arg_name}")
            
            java_text_element = function.find('implementation/javaText')
            if java_text_element is not None:
                udf_code = java_text_element.text
                return_type = "String"  # Default return type

                java_code += f"    public {return_type} {function_name}({', '.join(args)}) {{\n"
                java_code += f"        {udf_code.strip()}\n"
                java_code += f"    }}\n\n"

        java_code += "}"
        return class_name, java_code
    except Exception as e:
        print(f"    An error occurred during Function Library XML parsing: {e}")
        return None, None

#==============================================================================
# API CALL FUNCTIONS
#==============================================================================

def get_auth():
    return (CLIENT_ID, CLIENT_SECRET)

def execute_api_call(url, params, error_message_prefix):
    """Generic function to execute API calls and handle errors."""
    try:
        response = requests.post(url, params=params, auth=get_auth())
        response.raise_for_status()
        return response.text
    except requests.exceptions.RequestException as e:
        print(f"{error_message_prefix}: {e}")
        return None

def ICO_LIST():
    url = f"{BASE_URL}/dir/support/SimpleQuery"
    params = {"qc": "Default (for directory objects)", "businessL": "Business_sys_ASJava", "syncTabL": "true", "deletedL": "N", "xmlReleaseL": "7.1", "responseXMLL": "true", "types": "AllInOne", "result": "RA_XILINK", "action": "Start query"}
    return execute_api_call(url, params, "Error fetching ICO list")

def ICO_DETAILS(ico_key):
    url = f"{BASE_URL}/dir/read/ext"
    params = {"method": "PLAIN", "TYPE": "AllInOne", "KEY": ico_key, "VC": "DIR", "UC": "false", "release": "7.0"}
    return execute_api_call(url, params, f"Error fetching ICO details for key {ico_key}")

def OPERATION_MAPPING_DETAILS(key, swcguid):
    url = f"{BASE_URL}/rep/read/ext"
    params = {"method": "PLAIN", "TYPE": "MAPPING", "KEY": key, "VC": "SWC", "SWCGUID": swcguid, "SP": "-1", "UC": "false", "release": "7.0"}
    return execute_api_call(url, params, "Error fetching Operation Mapping details")

def MESSAGE_MAPPING_DETAILS(key, swcguid):
    url = f"{BASE_URL}/rep/read/ext"
    params = {"method": "PLAIN", "TYPE": "XI_TRAFO", "KEY": key, "VC": "SWC", "SWCGUID": swcguid, "SP": "-1", "UC": "true", "release": "7.0"}
    return execute_api_call(url, params, "Error fetching Message Mapping details")

def FUNCTION_LIBRARY_DETAILS(key, swcguid):
    url = f"{BASE_URL}/rep/read/ext"
    params = {"method": "PLAIN", "TYPE": "FUNC_LIB", "KEY": key, "VC": "SWC", "SWCGUID": swcguid, "SP": "-1", "UC": "true", "release": "7.0"}
    return execute_api_call(url, params, "Error fetching Function Library details")

#==============================================================================
# MAIN ORCHESTRATION LOGIC
#==============================================================================

def main():
    """
    Main function to orchestrate the UDF and Function Library extraction process.
    Connects to SAP PO, processes objects in memory, and saves source code to ZIP files.
    """
    print("Starting UDF & Function Library extraction process...")
    output_dir = "source-code"
    if not os.path.exists(output_dir):
        os.makedirs(output_dir)

    # 1. Get ICO List
    ico_list_html = ICO_LIST()
    if not ico_list_html:
        return

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

    # 2. Process each ICO
    processed_func_libs = set() # Keep track of processed function libraries to avoid duplicates

    for ico_key in ico_keys:
        print(f"\n--- Processing ICO: {ico_key} ---")
        ico_details_xml = ICO_DETAILS(ico_key)
        if not ico_details_xml:
            continue

        try:
            namespaces = {'p1': 'urn:sap-com:xi'}
            ico_root = ET.fromstring(ico_details_xml)
            
            map_roles = ico_root.findall(".//*[@role='MAP0']", namespaces)

            for map_role in map_roles:
                om_key_elem = map_role.find(".//p1:key[@typeID='MAPPING']", namespaces)
                if om_key_elem is not None:
                    om_name, om_namespace = [e.text for e in om_key_elem.findall("p1:elem", namespaces)]
                    om_key = f"{om_name}|{om_namespace}"
                    swcguid = map_role.find(".//p1:vc", namespaces).get('swcGuid')
                    print(f"  Found Operation Mapping: {om_key}")

                    om_details_xml = OPERATION_MAPPING_DETAILS(om_key, swcguid)
                    if not om_details_xml: continue
                    
                    om_root = ET.fromstring(om_details_xml)
                    
                    # Process Message Mappings linked in the Operation Mapping
                    for mm_key_elem in om_root.findall(".//p1:key[@typeID='XI_TRAFO']", namespaces):
                        mm_name, mm_namespace = [e.text for e in mm_key_elem.findall("p1:elem", namespaces)]
                        mm_key = f"{mm_name}|{mm_namespace}"
                        print(f"  -> Found Message Mapping: {mm_key}")

                        mm_details_xml = MESSAGE_MAPPING_DETAILS(mm_key, swcguid)
                        if not mm_details_xml: continue

                        mm_root = ET.fromstring(mm_details_xml)
                        
                        # --- In-memory UDF extraction from Message Mapping ---
                        source_code_blob = mm_root.find('.//tr:SourceCode/tr:blob', {'tr': 'urn:sap-com:xi:mapping:xitrafo'})
                        if source_code_blob is not None and source_code_blob.text:
                            print(f"    Found embedded UDFs. Processing in memory...")
                            try:
                                zip_data = base64.b64decode(source_code_blob.text.replace('!zip!', ''))
                                with zipfile.ZipFile(io.BytesIO(zip_data)) as z1:
                                    first_value_file_name = z1.namelist()[0]
                                    with z1.open(first_value_file_name) as f1, zipfile.ZipFile(io.BytesIO(f1.read())) as z2:
                                        second_value_file_name = z2.namelist()[0]
                                        with z2.open(second_value_file_name) as f2:
                                            java_content = f2.read().decode('utf-8', errors='ignore')
                                
                                # Parse the java content to get UDFs
                                extracted_udfs = parse_udfs_from_java_content(java_content)
                                
                                if extracted_udfs:
                                    # Save extracted UDFs to a zip file
                                    mm_zip_filename = mm_name.replace('/', '_').replace(':', '_') + ".zip"
                                    mm_zip_filepath = os.path.join(output_dir, mm_zip_filename)
                                    with zipfile.ZipFile(mm_zip_filepath, 'w', zipfile.ZIP_DEFLATED) as output_zip:
                                        for file_name, content in extracted_udfs.items():
                                            output_zip.writestr(file_name, content)
                                    print(f"    Successfully created UDF source archive: {mm_zip_filepath}")

                            except Exception as e:
                                print(f"    Error during in-memory UDF extraction: {e}")

                        # Process Function Libraries linked in the Message Mapping
                        for fl_key_elem in mm_root.findall(".//p1:key[@typeID='FUNC_LIB']", namespaces):
                            fl_name, fl_namespace = [e.text for e in fl_key_elem.findall("p1:elem", namespaces)]
                            fl_key = f"{fl_name}|{fl_namespace}"

                            if fl_key in processed_func_libs:
                                print(f"  -> Skipping already processed Function Library: {fl_key}")
                                continue
                            
                            print(f"  -> Found Function Library: {fl_key}")
                            processed_func_libs.add(fl_key)

                            fl_details_xml = FUNCTION_LIBRARY_DETAILS(fl_key, swcguid)
                            if not fl_details_xml: continue

                            fl_root = ET.fromstring(fl_details_xml)
                            
                            # --- In-memory processing for Function Library ---
                            blob_elem = fl_root.find('.//fl:blob', {'fl': 'urn:sap-com:xi:flib'})
                            if blob_elem is not None and blob_elem.text:
                                print(f"    Found embedded source. Processing in memory...")
                                try:
                                    zip_data = base64.b64decode(blob_elem.text.replace('!zip!', ''))
                                    with zipfile.ZipFile(io.BytesIO(zip_data)) as jar_file:
                                        if 'metaData.xml' in jar_file.namelist():
                                            xml_content = jar_file.read('metaData.xml')
                                            class_name, java_code = generate_java_from_funclib_xml(xml_content)
                                            
                                            if class_name and java_code:
                                                fl_zip_filename = fl_name.replace('/', '_').replace(':', '_') + ".zip"
                                                fl_zip_filepath = os.path.join(output_dir, fl_zip_filename)
                                                with zipfile.ZipFile(fl_zip_filepath, 'w', zipfile.ZIP_DEFLATED) as output_zip:
                                                    output_zip.writestr(f"{class_name}.java", java_code)
                                                print(f"    Successfully created Function Library source archive: {fl_zip_filepath}")
                                except Exception as e:
                                    print(f"    Error during in-memory Function Library extraction: {e}")

        except Exception as e:
            print(f"  An error occurred while processing ICO {ico_key}: {e}")

    print("\nUDF & Function Library extraction process finished.")

if __name__ == "__main__":
    if not all([BASE_URL, CLIENT_ID, CLIENT_SECRET]):
        print("Please ensure BASE_URL, CLIENT_ID, and CLIENT_SECRET are set in your .env file.")
    else:
        main()
