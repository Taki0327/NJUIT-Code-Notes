from flask import Flask,render_template
import random
app = Flask(__name__)

@app. route("/")
def index():
    rand_1 = random.randint(0, 1)
    return render_template("index2.html",name = rand_1)

if __name__ == '__main__':
    app.run(host='127.0.0.1',port='5000')