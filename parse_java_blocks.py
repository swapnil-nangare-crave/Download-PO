import os
import re
import sys
import zipfile

def parse_java_blocks(input_dir="output_udf", output_base_dir="source-code"):
    """
    Scans for value.java files, extracts code blocks, and saves them into a zip archive.
    """
    print(f"Starting Java block parsing process in {input_dir}...")

    if not os.path.exists(output_base_dir):
        os.makedirs(output_base_dir)

    for root, dirs, files in os.walk(input_dir):
        for file in files:
            if file == 'value.java':
                java_file_path = os.path.join(root, file)
                print(f"Processing: {java_file_path}")
                
                try:
                    with open(java_file_path, 'r', encoding='utf-8') as f:
                        inner_file_content = f.read()
                    
                    # Determine the output zip file path
                    relative_path = os.path.relpath(root, input_dir)
                    zip_file_name = f"{relative_path}.zip"
                    zip_file_path = os.path.join(output_base_dir, zip_file_name)

                    # Store extracted blocks in memory
                    extracted_blocks = {}

                    # Parse the content and extract function blocks
                    lines = inner_file_content.splitlines()
                    in_block = False
                    skiping_blocks = ['init', 'import', 'cleanUp', 'attributes']
                    current_block_name = None
                    current_block_code = []
                    
                    for line in lines:
                        start_match = re.search(r'// beginning of (.+?)\s+[a-f0-9]+', line)
                        end_match = re.search(r'// end of (.+?)\s+[a-f0-9]+', line)
                        
                        if start_match:
                            in_block = True
                            current_block_name = start_match.group(1).strip()
                            if current_block_name in skiping_blocks:
                                in_block = False
                                continue
                            current_block_code = []
                        elif end_match and in_block:
                            in_block = False
                            # Store the block code in the dictionary
                            file_name = f"{current_block_name}.java"
                            extracted_blocks[file_name] = "\n".join(current_block_code)
                            print(f"  Extracted block '{current_block_name}'")
                            current_block_code = []
                        elif in_block:
                            current_block_code.append(line)
                    
                    # If blocks were extracted, write them to the zip file
                    if extracted_blocks:
                        with zipfile.ZipFile(zip_file_path, "w", zipfile.ZIP_DEFLATED) as zf:
                            for file_name, content in extracted_blocks.items():
                                zf.writestr(file_name, content)
                        print(f"  Successfully created zip archive: {zip_file_path}")
                    else:
                        print(f"  No specific blocks found to extract. Skipping zip file creation.")

                except Exception as e:
                    print(f"Error processing {java_file_path}: {e}")

    print("\nJava block parsing process finished.")

if __name__ == "__main__":
    input_directory = "output_udf"
    output_directory = "source-code"

    if len(sys.argv) > 1:
        input_directory = sys.argv[1]
    if len(sys.argv) > 2:
        output_directory = sys.argv[2]

    parse_java_blocks(input_directory, output_directory)
