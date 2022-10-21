package com.sergio.pokedex


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CreditsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credits)
        takeAndShowUser()


    }

    private fun takeAndShowUser(){

        val user = intent.extras!!.get("User")
        val tvGreeting = findViewById<TextView>(R.id.tvGreetingUser)
        tvGreeting.text = getString(R.string.tv_user_greeting, user)

    }

    private fun sendMail(){



    }



}