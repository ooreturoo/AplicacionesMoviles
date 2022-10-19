package com.sergio.pokedex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnLogin).setOnClickListener{
            changeActivity()
        }
    }

    private fun changeActivity(){

        val etUser = findViewById<EditText>(R.id.etUser)

        if (etUser.text.isNotEmpty()){

            val intent = Intent(this, CreditsActivity::class.java)
            intent.putExtra("User",etUser.text)
            startActivity(intent)

        }else{

            Toast.makeText(this,getString(R.string.empty_user), Toast.LENGTH_SHORT).show()

        }

    }

}