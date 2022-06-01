from flask import Flask
app = Flask(__name__)
@app.route("/")
def index():
    for i in range(1,10):
        for j in range(1,i+1):
            print(str(j)+str("*")+str(i)+"="+str(i*j),end='\t')
        print()
    return 'Hello World!'

if __name__ == '__main__':
    app.run(host='127.0.0.1',port='5000')