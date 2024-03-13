package com.example.randomkino

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)

        val RegistrBtn: Button = findViewById(R.id.btnRegistr)
        val LoginBtn: Button = findViewById(R.id.btnAuth)
        val loginUser: EditText = findViewById(R.id.logintb)
        val passUser: EditText = findViewById(R.id.passwordtb)

        RegistrBtn.setOnClickListener {
            val regIntent = Intent(this,RegistrActivity::class.java)
            startActivity(regIntent)
        }


        LoginBtn.setOnClickListener{
            val login = loginUser.text.toString().trim()
            val psw = passUser.text.toString().trim()
            if (login == "" ||  psw == "" ){
                Toast.makeText(this,"Not all fields are filled in!", Toast.LENGTH_LONG).show()
            }
            else{
                val db = DataBaseUsers(this,null)
                val isAuth = db.getUser(login, psw)

                if(isAuth){
                    Toast.makeText(this,"User $login authorization!", Toast.LENGTH_LONG).show()
                    loginUser.text.clear()
                    passUser.text.clear()
                    val filterIntent = Intent(this, FilterMoviesActivity::class.java)
                    startActivity(filterIntent)
                }
                else{
                    Toast.makeText(this,"User $login NON authorization!", Toast.LENGTH_LONG).show()

                }

            }
        }

    }

}