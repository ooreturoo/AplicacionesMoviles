package com.example.practicapropia1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicapropia1.databinding.ActivityGreetingBinding

class GreetingActivity : AppCompatActivity() {

    private lateinit var blinding : ActivityGreetingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting)
        blinding = ActivityGreetingBinding.inflate(layoutInflater)
        setContentView(blinding.root)
        getAndShowName()
        blinding.btnBack.setOnClickListener{onBackPressed()}
    }

    fun getAndShowName(){

        val name = intent.extras!!.get("Name")
        blinding.tvGreeting.text = "Bienvenido $name"

    }

}