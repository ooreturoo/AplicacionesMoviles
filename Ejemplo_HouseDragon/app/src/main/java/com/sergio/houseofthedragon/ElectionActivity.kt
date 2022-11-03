package com.sergio.houseofthedragon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView

class ElectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_election)

        val intent = Intent(AlarmClock.ACTION_SET_TIMER).apply {
            putExtra(AlarmClock.EXTRA_LENGTH,10)
            putExtra(AlarmClock.EXTRA_MESSAGE,"Realiza una eleccion.")
            putExtra(AlarmClock.EXTRA_SKIP_UI, true)
        }

        try {
            startActivity(intent)
        }catch (e : Exception) {

        }

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

            decision.text = textChoice(targarianChoice(rhaenyra, aegon))

        }

        aegon.setOnClickListener {

            decision.text = textChoice(targarianChoice(rhaenyra, aegon))

        }



    }

    private fun targarianChoice(rhaenyra : CheckBox, aegon : CheckBox) : Int{

        val election =

        if (rhaenyra.isChecked && aegon.isChecked){

            2

        }else if (rhaenyra.isChecked){

           1

        }else if (aegon.isChecked){

           -1

        }else{

            0

        }

        return election

    }

    private fun textChoice(election : Int) : CharSequence {

        val text =

            when(election){
                1 -> getString(R.string.rhaenyra_choice)
                -1 -> getString(R.string.aegon_choice)
                2 -> getString(R.string.double_choice)
                else -> getString(R.string.empty_choice)

            }

        return text

    }
}