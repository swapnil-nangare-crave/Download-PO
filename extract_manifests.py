import os
import subprocess
import shutil

def extract_manifests(bytecode_dir="bytecode", metadata_dir="metadata"):
    """
    Extracts the MANIFEST.MF file from each JAR in the bytecode directory
    and saves it to the metadata directory using the tar command.
    """
    if not os.path.exists(metadata_dir):
        os.makedirs(metadata_dir)

    for filename in os.listdir(bytecode_dir):
        if filename.endswith(".jar"):
            jar_path = os.path.join(bytecode_dir, filename)
            print(f"Processing {jar_path}...")

            # Create a temporary directory to extract the manifest
            temp_dir = os.path.join(bytecode_dir, "temp_manifest")
            if os.path.exists(temp_dir):
                shutil.rmtree(temp_dir)
            os.makedirs(temp_dir)

            try:
                # Use tar to extract the MANIFEST.MF file
                subprocess.run(
                    ["tar", "-xf", os.path.abspath(jar_path), "META-INF/MANIFEST.MF"],
                    cwd=temp_dir,
                    check=True,
                    capture_output=True,
                    text=True
                )

                extracted_manifest_path = os.path.join(temp_dir, "META-INF", "MANIFEST.MF")
                
                if os.path.exists(extracted_manifest_path):
                    # Construct the new filename for the manifest
                    new_manifest_filename = f"{os.path.splitext(filename)[0]}_MANIFEST.MF"
                    new_manifest_path = os.path.join(metadata_dir, new_manifest_filename)

                    # Move the manifest file
                    shutil.move(extracted_manifest_path, new_manifest_path)
                    print(f"  Successfully extracted and moved manifest to {new_manifest_path}")
                else:
                    print(f"  Could not find MANIFEST.MF in {jar_path}")

            except (subprocess.CalledProcessError, FileNotFoundError) as e:
                if isinstance(e, subprocess.CalledProcessError) and e.stderr and ("not found in archive" in e.stderr.lower() or "no such file or directory" in e.stderr.lower()):
                    print(f"  MANIFEST.MF not found in {jar_path}. Skipping.")
                else:
                    print(f"  Error processing {jar_path}: {e}")
            finally:
                # Clean up the temporary directory
                shutil.rmtree(temp_dir)

if __name__ == "__main__":
    extract_manifests()