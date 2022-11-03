package com.sergio.houseofthedragon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView

class FinalActivity : AppCompatActivity() {

    private lateinit var imageView : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        imageView = findViewById<ImageView>(R.id.imageView)
        val switch : Switch = findViewById<Switch>(R.id.switch1)
        val buttonFight : Button = findViewById<Button>(R.id.btnExit)

        switch.setOnClickListener{

            if(switch.isChecked){

                buttonFight.isEnabled = true;
                switch.text = getString(R.string.switch_text_enable)

            }else{

                buttonFight.isEnabled = false;
                switch.text = getString(R.string.switch_text_disable)

            }

        }
        findViewById<TextView>(R.id.tvFinal).text = changeActivityElements(intent.getIntExtra("Choice",0))

        buttonFight.setOnClickListener{

            finish()

        }

    }

    private fun changeActivityElements(eleccion: Int): String {

        val newText : String
        var image : Int? = null
        when(eleccion){
            -1 -> {

                newText = getString(R.string.aegon_final)
                image = R.drawable.aegon
            }
            1 -> {
                newText = getString(R.string.rhaenyra_final)
                image = R.drawable.rhaenira
            }
            2 -> newText = getString(R.string.both_final)
            else -> newText = getString(R.string.undecided_final)
        }

        if(image != null){

            imageView.setImageResource(image)

        }

        return newText

    }


}