import os
import xml.etree.ElementTree as ET
import zipfile

def generate_java_from_xml(xml_content):
    """
    Parses the metaData.xml content, extracts UDF information,
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
                return_type = "String"  # Default

                java_code += f"    public {return_type} {function_name}({', '.join(args)}) {{\n"
                java_code += f"        {udf_code.strip()}\n"
                java_code += f"    }}\n\n"

        java_code += "}"
        return class_name, java_code

    except Exception as e:
        print(f"An error occurred during XML parsing: {e}")
        return None, None

def process_function_libraries(input_dir="bytecode", output_dir="source-code"):
    """
    Scans for Function Library JARs, generates Java source from their metaData.xml,
    and saves the source code into a ZIP archive.
    """
    print(f"Starting Function Library processing in {input_dir}...")

    if not os.path.exists(output_dir):
        os.makedirs(output_dir)

    for filename in os.listdir(input_dir):
        if filename.endswith(".jar"):
            jar_path = os.path.join(input_dir, filename)
            
            try:
                with zipfile.ZipFile(jar_path, 'r') as jar_file:
                    # Identify function libraries by the presence of metaData.xml
                    if 'metaData.xml' in jar_file.namelist():
                        print(f"Processing Function Library: {filename}")
                        xml_content = jar_file.read('metaData.xml')
                        
                        class_name, java_code = generate_java_from_xml(xml_content)
                        
                        if class_name and java_code:
                            # Create a zip file for this function library
                            zip_filename = os.path.splitext(filename)[0] + ".zip"
                            zip_filepath = os.path.join(output_dir, zip_filename)
                            
                            with zipfile.ZipFile(zip_filepath, 'w', zipfile.ZIP_DEFLATED) as output_zip:
                                output_zip.writestr(f"{class_name}.java", java_code)
                            
                            print(f"  Successfully created source archive: {zip_filepath}")
                        else:
                            print(f"  Failed to generate Java code from {filename}.")
            except zipfile.BadZipFile:
                # This can happen if the file is not a real JAR, so we just note it.
                print(f"  Skipping {filename}, as it is not a valid JAR/ZIP file.")
            except Exception as e:
                print(f"  An error occurred while processing {filename}: {e}")

    print("\nFunction Library processing finished.")

if __name__ == "__main__":
    process_function_libraries()
