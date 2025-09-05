import os
import re
import sys

def parse_java_blocks(input_dir="output_udf", output_base_dir="source-code"):
    """
    Scans for value.java files, extracts code blocks, and saves them as separate .java files.
    """
    print(f"Starting Java block parsing process in {input_dir}...")

    for root, dirs, files in os.walk(input_dir):
        for file in files:
            if file == 'value.java':
                java_file_path = os.path.join(root, file)
                print(f"Processing: {java_file_path}")
                
                try:
                    with open(java_file_path, 'r', encoding='utf-8') as f:
                        inner_file_content = f.read()
                    
                    # Determine the output directory for this message mapping
                    # It will be a subdirectory under output_base_dir, named after the parent folder in input_dir
                    relative_path = os.path.relpath(root, input_dir)
                    udf_output_dir = os.path.join(output_base_dir, relative_path)
                    if not os.path.exists(udf_output_dir):
                        os.makedirs(udf_output_dir)

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
                                current_block_name = None
                                current_block_code = []
                                continue
                            current_block_code = []
                        elif end_match and in_block:
                            in_block = False
                            # Save the block code to a .java file
                            file_path = os.path.join(udf_output_dir, f"{current_block_name}.txt")
                            with open(file_path, "w", encoding="utf-8") as f_out:
                                f_out.write("\n".join(current_block_code))
                            print(f"  Extracted block '{current_block_name}' to {file_path}")
                            current_block_name = None
                            current_block_code = []
                        elif in_block:
                            current_block_code.append(line)
                            
                    # If no blocks are found, skip saving the whole content
                    if not os.listdir(udf_output_dir):
                        if os.path.exists(udf_output_dir):
                            os.removedirs(udf_output_dir)
                        print(f"  No specific blocks found. Skipping the whole content.")


                except Exception as e:
                    print(f"Error processing {java_file_path}: {e}")

    print("\nJava block parsing process finished.")

if __name__ == "__main__":
    # Allow specifying input and output directories as arguments
    input_directory = "output_udf"
    output_directory = "source-code"

    if len(sys.argv) > 1:
        input_directory = sys.argv[1]
    if len(sys.argv) > 2:
        output_directory = sys.argv[2]

    parse_java_blocks(input_directory, output_directory)