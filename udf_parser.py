import xml.etree.ElementTree as ET
import os
import zipfile

def parse_and_save_udf(xml_content, output_dir):
    """
    Parses XML content from metaData, extracts UDF information,
    and saves it as a .java file in the specified output directory.
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
            
            # Extracting arguments
            args = []
            for arg in function.findall('signature/argument'):
                arg_type = arg.get('jtp')
                arg_name = arg.get('nm')
                args.append(f"{arg_type} {arg_name}")
            
            java_text_element = function.find('implementation/javaText')
            if java_text_element is not None:
                udf_code = java_text_element.text
                
                return_type = "String" # Default
                if "return " in udf_code:
                    pass

                java_code += f"    public {return_type} {function_name}({', '.join(args)}) {{\n"
                java_code += f"        {udf_code.strip()}\n"
                java_code += f"    }}\n\n"

        java_code += "}"

        os.makedirs(output_dir, exist_ok=True)
        java_file_path = os.path.join(output_dir, f"{class_name}.java")

        with open(java_file_path, "w", encoding="utf-8") as f:
            f.write(java_code)

        print(f"Successfully created {java_file_path}")

    except Exception as e:
        print(f"An error occurred: {e}")

if __name__ == "__main__":
    jar_path = "bytecode/FuncLib.jar"
    member_path = "metaData.xml"
    output_dir = "source-code/FuncLib"

    if not os.path.exists(jar_path):
        print(f"Error: {jar_path} not found.")
    else:
        try:
            with zipfile.ZipFile(jar_path, 'r') as zip_ref:
                if member_path in zip_ref.namelist():
                    xml_content = zip_ref.read(member_path).decode('utf-8')
                    parse_and_save_udf(xml_content, output_dir)
                else:
                    print(f"Error: {member_path} not found inside {jar_path}")
        except zipfile.BadZipFile:
            print(f"Error: {jar_path} is not a valid zip file.")
        except Exception as e:
            print(f"An error occurred while processing the JAR file: {e}")

