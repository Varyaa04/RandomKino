package com.example.randomkino

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseUsers(val context: Context,val factory: SQLiteDatabase.CursorFactory?):
        SQLiteOpenHelper(context,"app",factory,1){
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE users (id INT PRIMARY KEY AUTOINCREMENT, login TEXT, email TEXT, password TEXT)"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun addUser(users: User){
        val values = ContentValues()
        values.put("login", users.login)
        values.put("email", users.email)
        values.put("password", users.password)

        val db = this.writableDatabase
        db.insert("users", null,values)

        db.close()
    }

    fun getUser(login: String, password:String): Boolean {
        val db = this.readableDatabase
        val result = db.rawQuery("SELECT * FROM users WHERE login = '$login' AND password = '$password'",null)
        return result.moveToFirst()
    }
}