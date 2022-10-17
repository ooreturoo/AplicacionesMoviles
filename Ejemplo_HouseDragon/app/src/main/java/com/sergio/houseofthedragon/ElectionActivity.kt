package com.sergio.houseofthedragon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ElectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_election)

        val name = intent.extras!!.get("Name")
        val textView = findViewById<TextView>(R.id.tvGreeting)
        textView.text = getString(R.string.greeting_sir, name)

    }
}