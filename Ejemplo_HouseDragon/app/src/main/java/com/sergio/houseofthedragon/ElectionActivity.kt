package com.sergio.houseofthedragon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView

class ElectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_election)

        val name = intent.extras!!.get("Name")
        val textView = findViewById<TextView>(R.id.tvGreeting)
        textView.text = getString(R.string.greeting_sir, name)
        val btnKneelDown = findViewById<Button>(R.id.btnChoice)

        val rhaenyra = findViewById<CheckBox>(R.id.cBoxRhaenyra)
        val aegon = findViewById<CheckBox>(R.id.cBoxAegon)
        val decision = findViewById<TextView>(R.id.tvDecision)

        btnKneelDown.setOnClickListener {

            val intent = Intent(this,FinalActivity::class.java)
            intent.putExtra("Choice", targarianChoice(rhaenyra,aegon))
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)

        }

        rhaenyra.setOnClickListener{

            decision.text = targarianChoice(rhaenyra, aegon)

        }

        aegon.setOnClickListener {

            decision.text = targarianChoice(rhaenyra, aegon)

        }

    }

    private fun targarianChoice(rhaenyra : CheckBox, aegon : CheckBox) : CharSequence{

        val text : CharSequence

        if (rhaenyra.isChecked && aegon.isChecked){

            text = getString(R.string.double_choice)

        }else if (rhaenyra.isChecked){

            text = getString(R.string.rhaenyra_choice)

        }else if (aegon.isChecked){

            text = getString(R.string.aegon_choice)

        }else{

            text = getString(R.string.empty_choice)

        }

        return text

    }
}