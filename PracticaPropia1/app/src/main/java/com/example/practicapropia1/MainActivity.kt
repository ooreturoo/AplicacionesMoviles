package com.example.practicapropia1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.practicapropia1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var blinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        blinding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(blinding.root)

        blinding.btnSend.setOnClickListener{checkValue()}
    }

    fun checkValue(){

        if (blinding.etName.text.isNotEmpty()){

            val intent = Intent(this,GreetingActivity::class.java)
            intent.putExtra("Name", blinding.etName.text)
            startActivity(intent)


        }else{

         Toast.makeText(this, "El campo está vacío", Toast.LENGTH_LONG).show()

        }
    }
}