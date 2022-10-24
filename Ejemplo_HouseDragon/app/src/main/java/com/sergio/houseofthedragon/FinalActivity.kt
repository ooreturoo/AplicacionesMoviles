package com.sergio.houseofthedragon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FinalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        findViewById<TextView>(R.id.tvFinal).text = changeText(intent.getStringExtra("Choice")!!)
        findViewById<Button>(R.id.btnExit).setOnClickListener {

            finish()

        }

    }

    private fun changeText(text: String): String {

        val newText : String

        if(text == getString(R.string.double_choice) || text == getString(R.string.empty_choice)){

            newText = getString(R.string.undecided_final)

        }else if(text == getString(R.string.rhaenyra_choice)){

            newText = "Has elegido a Rhaenira."

        }else{

            newText = "Has elegido a Aegon."

        }

        return newText

    }
}