package com.sergio.pokedex


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.TextView
import android.widget.Toast

class CreditsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credits)
        takeAndShowUser()
        findViewById<TextView>(R.id.btnContact).setOnClickListener{
            sendMail()
        }


    }

    private fun takeAndShowUser(){

        val user = intent.extras!!.get("User")
        val tvGreeting = findViewById<TextView>(R.id.tvGreetingUser)
        tvGreeting.text = getString(R.string.tv_user_greeting, user)

    }

    private fun sendMail(){


        val intent = Intent(Intent.ACTION_SEND).apply {

            type="text/plain"
            putExtra(Intent.EXTRA_EMAIL, arrayOf("smatmor813@g.educaand.es"))
            putExtra(Intent.EXTRA_SUBJECT, getString(R.string.mail_subject,getString(R.string.app_name)))
            putExtra(Intent.EXTRA_TEXT, getString(R.string.mail_content,getString(R.string.app_name)))

        }

        if (intent.resolveActivity(packageManager) != null) {

            startActivity(intent)

        }else{

            Toast.makeText(this,"No se puede manejar el intent",Toast.LENGTH_SHORT).show()

        }


    }



}