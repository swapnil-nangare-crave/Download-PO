import requests
import xml.etree.ElementTree as ET
import base64
import os
import html
import zipfile
import io
import re
import sys

# --- Configuration ---
BASE_URL = "http://192.168.1.118:50000"
CLIENT_ID = "SAC_Swapnil"
CLIENT_SECRET = "Pass@111"
OUTPUT_BASE_DIR = "source-code"
# ---

# --- API Functions ---
def get_auth():
    return (CLIENT_ID, CLIENT_SECRET)

def _make_request(url, params, error_message):
    try:
        response = requests.post(url, params=params, auth=get_auth())
        response.raise_for_status()
        return response.text
    except requests.exceptions.RequestException as e:
        print(f"{error_message}: {e}")
        return None

def ICO_LIST():
    return _make_request(
        f"{BASE_URL}/dir/support/SimpleQuery",
        {"qc": "Default (for directory objects)", "businessL": "Business_sys_ASJava", "syncTabL": "true", "deletedL": "N", "xmlReleaseL": "7.1", "responseXMLL": "true", "types": "AllInOne", "result": "RA_XILINK", "action": "Start query"},
        "Error fetching ICO list"
    )

def ICO_DETAILS(ico_key):
    return _make_request(
        f"{BASE_URL}/dir/read/ext",
        {"method": "PLAIN", "TYPE": "AllInOne", "KEY": ico_key, "VC": "DIR", "UC": "false", "release": "7.0"},
        f"Error fetching ICO details for key {ico_key}"
    )

def OPERATION_MAPPING_DETAILS(key, swcguid):
    return _make_request(
        f"{BASE_URL}/rep/read/ext",
        {"method": "PLAIN", "TYPE": "MAPPING", "KEY": key, "VC": "SWC", "SWCGUID": swcguid, "SP": "-1", "UC": "false", "release": "7.0"},
        "Error fetching Operation Mapping details"
    )

def MESSAGE_MAPPING_DETAILS(key, swcguid):
    return _make_request(
        f"{BASE_URL}/rep/read/ext",
        {"method": "PLAIN", "TYPE": "XI_TRAFO", "KEY": key, "VC": "SWC", "SWCGUID": swcguid, "SP": "-1", "UC": "true", "release": "7.0"},
        "Error fetching Message Mapping details"
    )

def FUNCTION_LIBRARY_DETAILS(key, swcguid):
    return _make_request(
        f"{BASE_URL}/rep/read/ext",
        {"method": "PLAIN", "TYPE": "FUNC_LIB", "KEY": key, "VC": "SWC", "SWCGUID": swcguid, "SP": "-1", "UC": "true", "release": "7.0"},
        "Error fetching Function Library details"
    )

# --- Worker Functions ---

def parse_and_save_udf_from_content(xml_content, output_dir, class_name_override=None):
    """
    Parses XML content from metaData, extracts UDF information,
    and saves it as a .java file in the specified output directory.
    """
    try:
        root = ET.fromstring(xml_content)
        package_name = root.find('package').text
        class_name = class_name_override if class_name_override else root.find('classname').text
        imports = root.find('imports').text

        java_code = f"package {package_name};\n\n{imports}\n\npublic class {class_name} {{\n\n"

        for function in root.findall('functionmodel'):
            function_name = function.find('name').text
            args = [f"{arg.get('jtp')} {arg.get('nm')}" for arg in function.findall('signature/argument')]
            
            java_text_element = function.find('implementation/javaText')
            if java_text_element is not None:
                udf_code = java_text_element.text.strip()
                return_type = "String"  # Default
                java_code += f"    public {return_type} {function_name}({', '.join(args)}) {{\n        {udf_code}\n    }}\n\n"

        java_code += "}"

        os.makedirs(output_dir, exist_ok=True)
        java_file_path = os.path.join(output_dir, f"{class_name}.java")
        with open(java_file_path, "w", encoding="utf-8") as f:
            f.write(java_code)
        print(f"  Successfully created {java_file_path}")

    except Exception as e:
        print(f"  An error occurred during UDF parsing: {e}")

def parse_java_blocks_from_content(java_content, output_dir):
    """
    Scans raw java content, extracts code blocks, and saves them as separate .txt files.
    """
    try:
        os.makedirs(output_dir, exist_ok=True)
        lines = java_content.splitlines()
        in_block = False
        blocks_found = 0
        
        skiping_blocks = ['init', 'import', 'cleanUp', 'attributes']
        current_block_name = None
        current_block_code = []

        for line in lines:
            start_match = re.search(r'// beginning of (.+?)\s+[a-f0-9]+', line)
            end_match = re.search(r'// end of (.+?)\s+[a-f0-9]+', line)
            
            if start_match:
                current_block_name = start_match.group(1).strip()
                if current_block_name not in skiping_blocks:
                    in_block = True
                    current_block_code = []
            elif end_match and in_block:
                in_block = False
                blocks_found += 1
                file_path = os.path.join(output_dir, f"{current_block_name}.txt")
                with open(file_path, "w", encoding="utf-8") as f_out:
                    f_out.write("\n".join(current_block_code))
                print(f"  Extracted block '{current_block_name}' to {file_path}")
            elif in_block:
                current_block_code.append(line)
        
        if blocks_found == 0:
            print(f"  No specific UDF blocks found to extract.")
            # Clean up the created directory if no files were added
            if not os.listdir(output_dir):
                os.rmdir(output_dir)

    except Exception as e:
        print(f"  Error processing java blocks: {e}")

def process_standalone_jar(jar_path, output_dir):
    """
    Processes a standalone JAR file like FuncLib.jar.
    """
    print(f"--- Processing standalone JAR: {jar_path} ---")
    if not os.path.exists(jar_path):
        print(f"Error: {jar_path} not found.")
        return
    try:
        with zipfile.ZipFile(jar_path, 'r') as zip_ref:
            if "metaData.xml" in zip_ref.namelist():
                xml_content = zip_ref.read("metaData.xml").decode('utf-8')
                class_name = os.path.splitext(os.path.basename(jar_path))[0]
                parse_and_save_udf_from_content(xml_content, output_dir, class_name_override=class_name)
            else:
                print(f"  Error: metaData.xml not found inside {jar_path}")
    except Exception as e:
        print(f"  An error occurred while processing {jar_path}: {e}")


# --- Main Orchestration Logic ---
def main():
    """
    Main function to orchestrate the entire extraction and parsing process.
    """
    print("Starting unified UDF and Function Library extraction process...")
    if not os.path.exists(OUTPUT_BASE_DIR):
        os.makedirs(OUTPUT_BASE_DIR)

    # 1. Process standalone FuncLib.jar from bytecode directory
    process_standalone_jar("bytecode/FuncLib.jar", os.path.join(OUTPUT_BASE_DIR, "FuncLib"))

    # 2. Get ICO List
    print("\n--- Fetching all Integration Configurations (ICOs) from server ---")
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
        
        all_ico_keys = ['|'.join(elem.text or '' for elem in key_elem.findall('.//elem')) for key_elem in root.findall('.//qref/.//key')]
        print(f"Found {len(all_ico_keys)} ICOs to process.")

    except Exception as e:
        print(f"Error parsing ICO list XML: {e}")
        return

    # 3. Process each ICO
    for ico_key in all_ico_keys:
        print(f"\n--- Processing ICO: {ico_key} ---")
        ico_details_xml = ICO_DETAILS(ico_key)
        if not ico_details_xml: continue

        try:
            namespaces = {'p1': 'urn:sap-com:xi'}
            ET.register_namespace('p1', 'urn:sap-com:xi')
            ico_root = ET.fromstring(ico_details_xml)
            
            map_roles = ico_root.findall(".//p1:lnkRole[@role='MAP0']", namespaces) + \
                        ico_root.findall(".//p1:lnkRole[@role='REQUEST_TRAFO']", namespaces) + \
                        ico_root.findall(".//p1:lnkRole[@role='RESPONSE_TRAFO']", namespaces)

            for map_role in map_roles:
                om_key_elem = map_role.find(".//p1:key[@typeID='MAPPING']", namespaces)
                if om_key_elem is None: continue

                elems = om_key_elem.findall("p1:elem", namespaces)
                om_name = elems[0].text
                om_namespace = elems[1].text
                om_key = f"{om_name}|{om_namespace}"
                swcguid = map_role.find(".//p1:vc", namespaces).get('swcGuid')
                print(f"  Found Operation Mapping: {om_key}")

                om_details_xml = OPERATION_MAPPING_DETAILS(om_key, swcguid)
                if not om_details_xml: continue
                
                om_root = ET.fromstring(om_details_xml)
                for mm_key_elem in om_root.findall(".//p1:key[@typeID='XI_TRAFO']", namespaces):
                    mm_elems = mm_key_elem.findall("p1:elem", namespaces)
                    mm_name = mm_elems[0].text
                    mm_namespace = mm_elems[1].text
                    mm_key = f"{mm_name}|{mm_namespace}"
                    mm_key_filename = mm_key.replace('|','_').replace('/','_').replace(':','_').replace('*','_')
                    print(f"    Found Message Mapping: {mm_key}")

                    mm_details_xml = MESSAGE_MAPPING_DETAILS(mm_key, swcguid)
                    if not mm_details_xml: continue
                    
                    mm_root = ET.fromstring(mm_details_xml)
                    
                    # Process Embedded UDFs in Message Mapping
                    source_code_blob = mm_root.find('.//tr:SourceCode/tr:blob', {'tr': 'urn:sap-com:xi:mapping:xitrafo'})
                    if source_code_blob is not None and source_code_blob.text:
                        print(f"      Found embedded UDFs in Message Mapping.")
                        try:
                            zip_data = base64.b64decode(source_code_blob.text.replace('!zip!', ''))
                            with zipfile.ZipFile(io.BytesIO(zip_data)) as z1:
                                with zipfile.ZipFile(io.BytesIO(z1.read(z1.namelist()[0]))) as z2:
                                    java_content = z2.read(z2.namelist()[0]).decode('utf-8', errors='ignore')
                                    output_dir = os.path.join(OUTPUT_BASE_DIR, mm_key_filename)
                                    parse_java_blocks_from_content(java_content, output_dir)
                        except Exception as e:
                            print(f"      Error extracting embedded UDF: {e}")

                    # Process linked Function Libraries
                    for fl_key_elem in mm_root.findall(".//p1:key[@typeID='FUNC_LIB']", namespaces):
                        fl_elems = fl_key_elem.findall("p1:elem", namespaces)
                        fl_name = fl_elems[0].text
                        fl_namespace = fl_elems[1].text
                        fl_key = f"{fl_name}|{fl_namespace}"
                        print(f"      Found linked Function Library: {fl_key}")

                        fl_details_xml = FUNCTION_LIBRARY_DETAILS(fl_key, swcguid)
                        if not fl_details_xml: continue

                        try:
                            fl_root = ET.fromstring(fl_details_xml)
                            blob_elem = fl_root.find('.//fl:blob', {'fl': 'urn:sap-com:xi:flib'})
                            if blob_elem is not None and blob_elem.text:
                                zip_data = base64.b64decode(blob_elem.text.replace('!zip!', ''))
                                with zipfile.ZipFile(io.BytesIO(zip_data)) as z:
                                    if 'metaData.xml' in z.namelist():
                                        xml_content = z.read('metaData.xml').decode('utf-8')
                                        fl_dir_name = fl_name.replace('|','_').replace('/','_').replace('*','_')
                                        output_dir = os.path.join(OUTPUT_BASE_DIR, fl_dir_name)
                                        parse_and_save_udf_from_content(xml_content, output_dir, class_name_override=fl_name)
                        except Exception as e:
                            print(f"      Error processing function library {fl_key}: {e}")
        except Exception as e:
            print(f"  Error parsing ICO details for {ico_key}: {e}")

    print("\nUnified extraction process finished.")

if __name__ == "__main__":
    main()
