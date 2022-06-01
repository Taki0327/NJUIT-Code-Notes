from flask import Flask, url_for
app = Flask(__name__)

@app.route("/")
def index():
    print(url_for('my_list'))
    return 'Hello World!'

@app.route('/list/')
def my_list():
    return 'list'

if __name__ == '__main__':
    app.run(host='127.0.0.1',port='5000')