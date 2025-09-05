import os
import xml.etree.ElementTree as ET
import zipfile

def parse_and_save_udf(xml_file_path, output_dir):
    """
    Parses the metaData.xml file, extracts UDF information,
    and saves it as a .java file.
    """
    try:
        tree = ET.parse(xml_file_path)
        root = tree.getroot()

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
                
                return_type = "String" # Default

                java_code += f"    public {return_type} {function_name}({', '.join(args)}) {{\n"
                java_code += f"        {udf_code.strip()}\n"
                java_code += f"    }}\n\n"

        java_code += "}"

        java_file_path = os.path.join(output_dir, f"{class_name}.java")

        with open(java_file_path, "w", encoding="utf-8") as f:
            f.write(java_code)

        print(f"Successfully created {java_file_path}")

    except Exception as e:
        print(f"An error occurred while processing {xml_file_path}: {e}")

def process_all_udfs(start_dir="source-code"):
    """
    Scans for function libraries, extracts metadata, and creates java files.
    """
    for root, dirs, files in os.walk(start_dir):
        if 'value' in files:
            value_file_path = os.path.join(root, 'value')
            print(f"Processing Function Library: {value_file_path}")
            
            try:
                with zipfile.ZipFile(value_file_path, 'r') as zip_ref:
                    zip_ref.extractall(root)
                print(f"  Extracted contents of {value_file_path}")
                
                metadata_path = os.path.join(root, 'metaData.xml')
                if os.path.exists(metadata_path):
                    parse_and_save_udf(metadata_path, root)
                else:
                    print(f"  Could not find metaData.xml in {root}")
            except zipfile.BadZipFile:
                # This is expected for message mappings, so we can ignore this error.
                print(f"  Skipping {value_file_path} as it is not a zip file (likely a message mapping UDF).")
            except Exception as e:
                print(f"  An error occurred while processing {value_file_path}: {e}")

if __name__ == "__main__":
    process_all_udfs()