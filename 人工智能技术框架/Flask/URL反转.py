from flask import Flask, url_for
app = Flask(__name__)

@app.route("/")
def index():
    url_1 = (url_for("today_news", id = "10086"))
    return "URL反转内容为: %s" % url_1

@app.route("/news810/<id>")
def today_news(id):
    return u"您请求的参数是: %s" % id

if __name__ == '__main__':
    app.run(host='127.0.0.1',port='5000')

