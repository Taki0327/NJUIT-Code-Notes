from flask import Flask

app = Flask(__name__)

@app.route("/")
def index():
    return "Hello World"

@app.route("/user/<name>")
def visitByName(name):
    return "接收到的名称为: %s" % name

@app.route("/user/<int:id>")
def visitByld(id):
    return "接收到的id为: %s" % id

@app.route("/user/<float:number>")
def visitByNumber(number):
    return "接收到的float为: %s" % number

if __name__ == '__main__':
    app.run(host='127.0.0.1',port='5000')
