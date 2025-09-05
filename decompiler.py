import os
import subprocess
import shutil
import tempfile

# --- Configuration ---
# Path to the Procyon decompiler JAR file.
PROCYON_DECOMPILER_JAR = "procyon-decompiler-0.6.0.jar"
# Absolute path to the java and jar executables.
# Replace these with the actual paths on your system if they are not in the PATH.
JAVA_EXECUTABLE = r"C:\Program Files\Microsoft\jdk-21.0.8.9-hotspot\bin\java.exe"
JAR_EXECUTABLE = r"C:\Program Files\Microsoft\jdk-21.0.8.9-hotspot\bin\jar.exe"
# ---

def decompile_jar_file(jar_path, output_dir):
    """
    Decompiles a single .jar file.
    """
    if not os.path.exists(PROCYON_DECOMPILER_JAR):
        print(f"Error: Procyon decompiler JAR not found at '{PROCYON_DECOMPILER_JAR}'")
        print("Please download it from https://github.com/mstrobel/procyon/releases and place it in the same directory as this script.")
        return

    print(f"Decompiling {jar_path}...")

    # Create a temporary directory to extract the class files
    with tempfile.TemporaryDirectory() as temp_dir:
        try:
            # Extract all files from the JAR
            subprocess.run([JAR_EXECUTABLE, "-xf", os.path.abspath(jar_path)], cwd=temp_dir, check=True)
            print(f"  Extracted contents of {os.path.basename(jar_path)} to a temporary directory.")

            # Find and decompile all .class files
            for root, dirs, files in os.walk(temp_dir):
                for file in files:
                    if file.endswith(".class"):
                        class_file_path = os.path.join(root, file)
                        print(f"  Decompiling {file}...")
                        
                        # Construct the command to run the decompiler
                        # The -o flag specifies the output directory
                        command = [
                            JAVA_EXECUTABLE,
                            "-jar",
                            os.path.abspath(PROCYON_DECOMPILER_JAR),
                            "-o",
                            os.path.abspath(output_dir),
                            os.path.abspath(class_file_path)
                        ]

                        # Run the decompiler
                        result = subprocess.run(command, capture_output=True, text=True)

                        if result.returncode != 0:
                            if result.stderr:
                                print(f"    Error decompiling {file}:")
                                print(result.stderr)
                            if result.stdout:
                                print(f"    Output from decompiler for {file}:")
                                print(result.stdout)
            
            print(f"Successfully decompiled {jar_path} to {output_dir}")

        except FileNotFoundError:
            print(f"Error: '{JAVA_EXECUTABLE}' or '{JAR_EXECUTABLE}' not found. Please check the paths in the configuration section of this script.")
        except subprocess.CalledProcessError as e:
            print(f"An error occurred while processing {jar_path}: {e}")
            if e.stderr:
                print(e.stderr)
        except Exception as e:
            print(f"An unexpected error occurred while decompiling {jar_path}: {e}")

def main(input_dir="bytecode", output_base_dir="source-code/decompiled"):
    """
    Main function to start the decompilation process.
    """
    print("Starting JAR file decompilation process...")

    if not os.path.exists(input_dir):
        print(f"Error: Input directory '{input_dir}' not found.")
        return

    if not os.path.exists(output_base_dir):
        os.makedirs(output_base_dir)

    for filename in os.listdir(input_dir):
        if filename.endswith(".jar"):
            jar_path = os.path.join(input_dir, filename)
            
            # Create a dedicated output directory for each JAR
            jar_output_dir = os.path.join(output_base_dir, os.path.splitext(filename)[0])
            if not os.path.exists(jar_output_dir):
                os.makedirs(jar_output_dir)
            
            decompile_jar_file(jar_path, jar_output_dir)

    print("\nDecompilation process finished.")

if __name__ == "__main__":
    main()