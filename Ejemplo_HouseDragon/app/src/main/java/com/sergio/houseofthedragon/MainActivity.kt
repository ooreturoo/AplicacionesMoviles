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
            startActivity(intent)

        }else{

            Toast.makeText(this,"El campo está vacío", Toast.LENGTH_SHORT).show()

        }

    }
}