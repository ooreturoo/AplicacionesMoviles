package com.sergio.pokedex.credits

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.sergio.pokedex.R
import com.sergio.pokedex.databinding.FragmentCreditsBinding


class CreditsFragment : Fragment() {



    private lateinit var binding : FragmentCreditsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreditsBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        takeAndShowUser()

        binding.btnContact.setOnClickListener{
            sendMail()
        }

    }

    private fun takeAndShowUser(){

        //Usuario pepe por defecto de momento.
        val user = "Pepe"
        val tvGreeting = binding.tvGreetingUser
        tvGreeting.text = getString(R.string.tv_user_greeting, user)

    }

    private fun sendMail(){


        val intent = Intent(Intent.ACTION_SEND).apply {

            type="text/plain"
            putExtra(Intent.EXTRA_EMAIL, arrayOf("smatmor813@g.educaand.es"))
            putExtra(Intent.EXTRA_SUBJECT, getString(R.string.mail_subject,getString(R.string.app_name)))
            putExtra(Intent.EXTRA_TEXT, getString(R.string.mail_content,getString(R.string.app_name)))

        }

        if (intent.resolveActivity(requireContext().packageManager) != null) {

            startActivity(intent)

        }else{

            Toast.makeText(requireContext(),"No se puede manejar el intent", Toast.LENGTH_SHORT).show()

        }


    }

}