from flask import Flask,render_template,request
import os
app = Flask(__name__)
@app.route('/', methods=['GET' ,'POST'])
def index() :#定义视图函数
    if request.method=='GET':
        return render_template('upload.html')
    else:
        f=request.files['uploadfile']
        basepath=os.path.join(os.path.dirname(__file__),'upload')
        f.save(os.path.join(basepath,f.filename))
        return render_template('result.html')
        
#重定向到主页
def redirect_to_upload():
    return render_template("upload.html")
app.add_url_rule(rule='/',endpoint='home',view_func=redirect_to_upload)

if __name__ == '__main__':
    app.run(host='127.0.0.1',port='5000')