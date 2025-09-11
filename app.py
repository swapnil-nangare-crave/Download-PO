from flask import Flask, render_template, request, send_file
import subprocess
import os
import zipfile
import shutil

app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/execute', methods=['POST'])
def execute():
    base_url = request.form['base_url']
    client_id = request.form['client_id']
    client_secret = request.form['client_secret']

    # Clean up previous output directories
    if os.path.exists('output'):
        shutil.rmtree('output')
    if os.path.exists('output_udf_funclib'):
        shutil.rmtree('output_udf_funclib')
    
    os.makedirs('output')
    os.makedirs('output_udf_funclib')

    env = {
        **os.environ,
        'BASE_URL': base_url,
        'CLIENT_ID': client_id,
        'CLIENT_SECRET': client_secret,
    }

    # Run java_mapping.py
    subprocess.run(['python', 'java_mapping.py'], env=env, check=True)

    # Run udf_extractor.py
    subprocess.run(['python', 'udf_extractor.py'], env=env, check=True)

    # Create zip files
    java_mapping_zip = 'output.zip'
    udf_extractor_zip = 'output_udf_funclib.zip'

    with zipfile.ZipFile(java_mapping_zip, 'w', zipfile.ZIP_DEFLATED) as zf:
        for root, _, files in os.walk('output'):
            for file in files:
                zf.write(os.path.join(root, file), os.path.relpath(os.path.join(root, file), 'output'))

    with zipfile.ZipFile(udf_extractor_zip, 'w', zipfile.ZIP_DEFLATED) as zf:
        for root, _, files in os.walk('output_udf_funclib'):
            for file in files:
                zf.write(os.path.join(root, file), os.path.relpath(os.path.join(root, file), 'output_udf_funclib'))

    # Create a single zip file to contain both outputs
    master_zip_filename = 'extraction_results.zip'
    with zipfile.ZipFile(master_zip_filename, 'w', zipfile.ZIP_DEFLATED) as master_zf:
        master_zf.write(java_mapping_zip)
        master_zf.write(udf_extractor_zip)

    # Return the master zip file
    return send_file(master_zip_filename, as_attachment=True, mimetype='application/zip')

if __name__ == '__main__':
    app.run(debug=True)
