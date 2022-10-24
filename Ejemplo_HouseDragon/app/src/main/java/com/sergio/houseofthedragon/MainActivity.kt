package com.sergio.houseofthedragon

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

        val btnAnswer = findViewById<Button>(R.id.btnAnswer)
        btnAnswer.setOnClickListener{

            goToElection()

        }
    }

    fun goToElection(){

        val name = findViewById<EditText>(R.id.atName)

        if(name.text.isNotEmpty()){

            val intent = Intent(this, ElectionActivity::class.java)
            intent.putExtra("Name",name.text)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()

        }else{

            Toast.makeText(this,getString(R.string.empty_field), Toast.LENGTH_SHORT).show()

        }

    }



}