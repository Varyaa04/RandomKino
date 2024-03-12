package com.example.randomkino

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)
    }

//    fun RegPage(view: View){
//        val RegIntent = Intent(this, RegistrationActivity::class.java)
//        startActivity(RegIntent)
//    }
}