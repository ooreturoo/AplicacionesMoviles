package com.sergio.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sergio.colormyviews.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        binding.boxOneText.setOnClickListener{
            makeColored(it)
        }
        binding.boxTwoText.setOnClickListener{
            makeColored(it)
        }
        binding.boxThreeText.setOnClickListener{
            makeColored(it)
        }
        binding.boxFourText.setOnClickListener{
            makeColored(it)
        }
        binding.boxFiveText.setOnClickListener{
            makeColored(it)
        }
        binding.boxSixText.setOnClickListener{
            makeColored(it)
        }
        binding.boxSevenText.setOnClickListener{
            makeColored(it)
        }
        binding.boxEightText.setOnClickListener{
            makeColored(it)
        }
        binding.boxNineText.setOnClickListener{
            makeColored(it)
        }
        binding.boxTenText.setOnClickListener{
            makeColored(it)
        }
        binding.root.setOnClickListener{
            makeColored(it)
        }



    }

    private fun makeColored(view : View){

        val colores : List<Int> = listOf(Color.RED,Color.BLACK,Color.GREEN,Color.BLUE,Color.YELLOW,Color.rgb(246,128,11),Color.MAGENTA)
//        when(view.id){
//
//            R.id.box_one_text -> view.setBackgroundColor(Color.BLUE)
//            R.id.box_two_text -> view.setBackgroundColor(Color.CYAN)
//            R.id.box_three_text -> view.setBackgroundColor(Color.DKGRAY)
//            R.id.box_four_text -> view.setBackgroundColor(Color.MAGENTA)
//            R.id.box_five_text -> view.setBackgroundColor(Color.RED)
//            else -> view.setBackgroundColor(Color.LTGRAY)
//
//        }

        if(view.id == R.id.contraint_layout){
            view.setBackgroundColor(Color.LTGRAY)
        }else {
            view.setBackgroundColor(Color.rgb(Random.nextInt(0,255),Random.nextInt(0,255),Random.nextInt(0,255)))
        }


    }

}