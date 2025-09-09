import requests
import xml.etree.ElementTree as ET
import base64
import os
import html
import zipfile
import io
import re
import concurrent.futures
import threading

# --- Configuration ---
from dotenv import load_dotenv
load_dotenv( dotenv_path=".env", override=True)

BASE_URL = os.getenv("BASE_URL")
CLIENT_ID = os.getenv("CLIENT_ID")
CLIENT_SECRET = os.getenv("CLIENT_SECRET")
# ---

#==============================================================================
# THREAD-SAFE SET for tracking processed items
#==============================================================================
class ThreadSafeSet:
    """A set that is safe to access from multiple threads."""
    def __init__(self):
        self._set = set()
        self._lock = threading.Lock()

    def add(self, item):
        """Adds an item to the set. Returns True if added, False if it already existed."""
        with self._lock:
            if item in self._set:
                return False
            self._set.add(item)
            return True

#==============================================================================
# HELPER FUNCTIONS (for parsing and processing)
#==============================================================================

def parse_udfs_from_java_content(java_content):
    """Parses raw Java code to extract UDF blocks."""
    extracted_blocks = {}
    lines = java_content.splitlines()
    in_block = False
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
            file_name = f"{current_block_name}.txt"
            extracted_blocks[file_name] = "\n".join(current_block_code)
            current_block_code = []
        elif in_block:
            current_block_code.append(line)
            
    return extracted_blocks

def generate_java_from_funclib_xml(xml_content):
    """Parses the XML content from a Function Library to generate Java source."""
    try:
        root = ET.fromstring(xml_content)
        package_elem = root.find('package')
        if package_elem is None or package_elem.text is None: return None, None
        package_name = package_elem.text

        class_elem = root.find('classname')
        if class_elem is None or class_elem.text is None: return None, None
        class_name = class_elem.text

        imports_elem = root.find('imports')
        imports = imports_elem.text if imports_elem is not None and imports_elem.text is not None else ""

        java_code = f"package {package_name};\n\n{imports}\n\npublic class {class_name} {{\n\n"

        for function in root.findall('functionmodel'):
            function_name = function.find('name').text
            args = [f"{arg.get('jtp')} {arg.get('nm')}" for arg in function.findall('signature/argument')]
            java_text_element = function.find('implementation/javaText')
            if java_text_element is not None and java_text_element.text is not None:
                udf_code = java_text_element.text
                return_type = "String"
                java_code += f"    public {return_type} {function_name}({', '.join(args)}) {{\n        {udf_code.strip()}\n    }}\n\n"

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
    return execute_api_call(url, params, f"Error fetching Operation Mapping details for {key}")

def MESSAGE_MAPPING_DETAILS(key, swcguid):
    url = f"{BASE_URL}/rep/read/ext"
    params = {"method": "PLAIN", "TYPE": "XI_TRAFO", "KEY": key, "VC": "SWC", "SWCGUID": swcguid, "SP": "-1", "UC": "true", "release": "7.0"}
    return execute_api_call(url, params, f"Error fetching Message Mapping details for {key}")

def FUNCTION_LIBRARY_DETAILS(key, swcguid):
    url = f"{BASE_URL}/rep/read/ext"
    params = {"method": "PLAIN", "TYPE": "FUNC_LIB", "KEY": key, "VC": "SWC", "SWCGUID": swcguid, "SP": "-1", "UC": "true", "release": "7.0"}
    return execute_api_call(url, params, f"Error fetching Function Library details for {key}")

#==============================================================================
# MAIN ORCHESTRATION LOGIC
#==============================================================================

def process_single_ico(ico_key, processed_func_libs, output_dir):
    """Processes a single ICO to find and extract UDFs and Function Libraries."""
    print(f"--- Processing ICO: {ico_key} ---")
    ico_details_xml = ICO_DETAILS(ico_key)
    if not ico_details_xml: return

    namespaces = {'p1': 'urn:sap-com:xi'}
    ico_root = ET.fromstring(ico_details_xml)
    
    for map_role in ico_root.findall(".//*[@role='MAP0']", namespaces):
        om_key_elem = map_role.find(".//p1:key[@typeID='MAPPING']", namespaces)
        if om_key_elem is not None:
            om_name, om_namespace = [e.text for e in om_key_elem.findall("p1:elem", namespaces)]
            om_key = f"{om_name}|{om_namespace}"
            swcguid = map_role.find(".//p1:vc", namespaces).get('swcGuid')

            om_details_xml = OPERATION_MAPPING_DETAILS(om_key, swcguid)
            if not om_details_xml: continue
            
            om_root = ET.fromstring(om_details_xml)
            
            for mm_key_elem in om_root.findall(".//p1:key[@typeID='XI_TRAFO']", namespaces):
                mm_name, mm_namespace = [e.text for e in mm_key_elem.findall("p1:elem", namespaces)]
                mm_key = f"{mm_name}|{mm_namespace}"
                print(f"  [{ico_key}] Found Message Mapping: {mm_key}")

                mm_details_xml = MESSAGE_MAPPING_DETAILS(mm_key, swcguid)
                if not mm_details_xml: continue

                mm_root = ET.fromstring(mm_details_xml)
                
                # Process UDFs embedded in the Message Mapping
                source_code_blob = mm_root.find('.//tr:SourceCode/tr:blob', {'tr': 'urn:sap-com:xi:mapping:xitrafo'})
                if source_code_blob is not None and source_code_blob.text:
                    try:
                        zip_data = base64.b64decode(source_code_blob.text.replace('!zip!', ''))
                        with zipfile.ZipFile(io.BytesIO(zip_data)) as z1, zipfile.ZipFile(io.BytesIO(z1.read(z1.namelist()[0]))) as z2:
                            java_content = z2.read(z2.namelist()[0]).decode('utf-8', errors='ignore')
                        extracted_udfs = parse_udfs_from_java_content(java_content)
                        if extracted_udfs:
                            mm_zip_filename = mm_name.replace('/', '_').replace(':', '_') + ".zip"
                            with zipfile.ZipFile(os.path.join(output_dir, mm_zip_filename), 'w', zipfile.ZIP_DEFLATED) as zf:
                                for file_name, content in extracted_udfs.items(): zf.writestr(file_name, content)
                            print(f"    [{ico_key}] Created UDF archive: {mm_zip_filename}")
                    except Exception as e:
                        print(f"    [{ico_key}] Error extracting UDFs from {mm_key}: {e}")

                # Process Function Libraries linked from the Message Mapping
                for fl_key_elem in mm_root.findall(".//p1:key[@typeID='FUNC_LIB']", namespaces):
                    fl_name, fl_namespace = [e.text for e in fl_key_elem.findall("p1:elem", namespaces)]
                    fl_key = f"{fl_name}|{fl_namespace}"

                    if processed_func_libs.add(fl_key):
                        print(f"  [{ico_key}] Found Function Library: {fl_key}")
                        fl_details_xml = FUNCTION_LIBRARY_DETAILS(fl_key, swcguid)
                        if not fl_details_xml: continue

                        fl_root = ET.fromstring(fl_details_xml)
                        blob_elem = fl_root.find('.//fl:blob', {'fl': 'urn:sap-com:xi:flib'})
                        if blob_elem is not None and blob_elem.text:
                            try:
                                zip_data = base64.b64decode(blob_elem.text.replace('!zip!', ''))
                                with zipfile.ZipFile(io.BytesIO(zip_data)) as z1:
                                    if 'value' in z1.namelist():
                                        value_content = z1.read('value')
                                        with zipfile.ZipFile(io.BytesIO(value_content)) as z2:
                                            if 'metaData.xml' in z2.namelist():
                                                xml_content = z2.read('metaData.xml')
                                                class_name, java_code = generate_java_from_funclib_xml(xml_content)
                                                if class_name and java_code:
                                                    fl_zip_filename = fl_name.replace('/', '_').replace(':', '_') + ".zip"
                                                    with zipfile.ZipFile(os.path.join(output_dir, fl_zip_filename), 'w', zipfile.ZIP_DEFLATED) as zf:
                                                        zf.writestr(f"{class_name}.txt", java_code)
                                                    print(f"    [{ico_key}] Created Function Library archive: {fl_zip_filename}")
                            except Exception as e:
                                print(f"    [{ico_key}] Error processing Function Library {fl_key}: {e}")

def main():
    """
    Main function to orchestrate the extraction process in parallel.
    """
    output_dir = "output-udfs"
    if not os.path.exists(output_dir):
        os.makedirs(output_dir)

    print("Starting UDF & Function Library extraction process...")
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

    processed_func_libs = ThreadSafeSet()
    
    with concurrent.futures.ThreadPoolExecutor(max_workers=10) as executor:
        futures = [executor.submit(process_single_ico, key, processed_func_libs, output_dir) for key in ico_keys]
        
        for future in concurrent.futures.as_completed(futures):
            try:
                future.result()
            except Exception as e:
                print(f"An error occurred in a worker thread: {e}")

    print("\nUDF & Function Library extraction process finished.")

if __name__ == "__main__":
    if not all([BASE_URL, CLIENT_ID, CLIENT_SECRET]):
        print("Please ensure BASE_URL, CLIENT_ID, and CLIENT_SECRET are set in your .env file.")
    else:
        main()
