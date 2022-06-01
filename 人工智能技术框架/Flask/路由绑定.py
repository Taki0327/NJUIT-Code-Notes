from flask import Flask,url_for
app = Flask(__name__)

app.route("/")
def index():
    return 'helloworld'
    
def my_test():
    return '这个是测试函数 my_test'
app.add_url_rule(rule='/test/',endpoint='test',view_func=my_test)
with app.test_request_context() :
    print(url_for('test'))
    print(url_for('index'))

if __name__ == '__main__':
    app.run(host='127.0.0.1',port='5000')