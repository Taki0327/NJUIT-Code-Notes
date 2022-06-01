from flask import Flask,render_template,request
app = Flask(__name__)

@app. route("/")
def index():
    return render_template("index3.html")

@app.route('/login', methods=['GET' ,'POST'])
def login() :#定义视图函数
    if request.method=='GET':
        return '这是get请求’#返回应答信息'
    else:
        return '这是POST请求’#返回应答信息'

if __name__ == '__main__':
    app.run(host='127.0.0.1',port='5000')