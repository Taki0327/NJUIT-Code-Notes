from flask import Flask,render_template
app = Flask(__name__)

app.route("/")
def index():
    title="python的键值对"
    author="tom_jack"
    return render_template("index.html",var_1=title,var_2=author)
@app. route ("/user/<username>")
def user (username) :
    return render_template("user.html",var_1=username)

if __name__ == '__main__':
    app.run(host='127.0.0.1',port='5000')
