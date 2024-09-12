import sqlite3
from flask import Flask, request

app = Flask(__name__)

# Insecure code: vulnerable to SQL Injection
@app.route('/get_user')
def get_user():
    user_id = request.args.get('id')
    conn = sqlite3.connect('database.db')
    cursor = conn.cursor()

    # Directly concatenating user input into SQL query
    query = f"SELECT * FROM users WHERE id = {user_id};"
    cursor.execute(query)

    result = cursor.fetchall()
    conn.close()

    return str(result)

if __name__ == '__main__':
    app.run()
