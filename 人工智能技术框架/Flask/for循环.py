from flask import Flask,render_template
app = Flask(__name__)

app.route("/")
def shop() :
    goods_item = [{"name" :'韩版运动衫',"price": 138.00},{"name":"美版长袖T恤","price": 206.58}, {"name":"西式长裤","price": 582}]
    return render_template('shop.html',goods=goods_item)

if __name__ == '__main__':
    app.run(host='127.0.0.1',port='5000')