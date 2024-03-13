package com.example.randomkino

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegistrActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registr_page)

        val registrBtn: Button = findViewById(R.id.button_registr)
        val BackBth: Button = findViewById(R.id.button_back)
        val loginUser: EditText = findViewById(R.id.input_login)
        val emailUser: EditText = findViewById(R.id.input_email)
        val passwordUser: EditText = findViewById(R.id.input_password)
        val passwordRepeat: EditText = findViewById(R.id.input_passwordrepeat)

        BackBth.setOnClickListener{
            val backIntent = Intent(this,LoginActivity::class.java)
            startActivity(backIntent)
        }

        registrBtn.setOnClickListener{
            val login = loginUser.text.toString().trim()
            val email = emailUser.text.toString().trim()
            val psw = passwordUser.text.toString().trim()
            val pswRepeat = passwordRepeat.text.toString().trim()
            if (login == "" || email == "" || psw == "" || pswRepeat == ""){
                Toast.makeText(this,"Not all fields are filled in!",Toast.LENGTH_LONG).show()
            }
            else{
                if (psw != pswRepeat){
                    Toast.makeText(this,"Password mismatch!", Toast.LENGTH_SHORT).show()
                    passwordRepeat.text.clear()
                }
                val user = User(login,email,psw)

                val db = DataBaseUsers(this,null)
                Toast.makeText(this,"User $login added!", Toast.LENGTH_LONG).show()
                val backIntent = Intent(this,LoginActivity::class.java)
                startActivity(backIntent)

                loginUser.text.clear()
                emailUser.text.clear()
                passwordUser.text.clear()
                passwordRepeat.text.clear()

            }
        }


    }
}