from flask import Flask, render_template
import sqlite3

app = Flask(__name__)


@app.route('/')
def index():
    return render_template('index.html')


@app.route('/game.js')
def game():
    return app.send_static_file('game.js')


@app.route('/login')
def login():
    return render_template('login.html')


if __name__ == '__main__':
    app.run()
