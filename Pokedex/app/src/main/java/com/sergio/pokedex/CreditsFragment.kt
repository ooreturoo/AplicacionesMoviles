package com.sergio.pokedex

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.sergio.pokedex.databinding.FragmentCreditsBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CreditsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreditsFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding : FragmentCreditsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_credits, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCreditsBinding.inflate(layoutInflater)
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CreditsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CreditsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}