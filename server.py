from flask import Flask, render_template
import jsonify
import json
import request

app = Flask(__name__)


@app.route('/')
#routes 'index.html' to / on webpage
def index():
    return render_template('index.html')


@app.route('/game.js')
def game():
    return app.send_static_file('game.js')


@app.route('/login')
#routes 'login.html' to /login on webpage
def login():
    return render_template('login.html')


@app.route('/', methods=['GET', 'POST'])
def results():
    if request.method == 'POST':
        json.dump(request.form)
    return render_template('login.html')



#creating a json file for all of the usernames, score, and location
def toJson():
    USERNAME = "aivothom"
    SCORE = 86
    x = 0
    y = 0
    data = {
        'name': USERNAME,
        'score': SCORE,
        'location': {'x': x, 'y': y}}
    return json.dumps(data)


#taking the created json file, reading it and returning the data
def fromJson():
    return 0.0


if __name__ == '__main__':
    app.run("0.0.0.0")
