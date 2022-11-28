package com.sergio.pokedex.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.sergio.pokedex.R
import com.sergio.pokedex.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {

    private lateinit var binding : FragmentMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater,container,false)

        binding.btnLogOut.setOnClickListener{

            it.findNavController().navigate(R.id.action_menuFragment_to_loginFragment)

        }
        binding.btnPokedex.setOnClickListener {

            it.findNavController().navigate(R.id.action_menuFragment_to_pokemonListFragment)

        }
        binding.btnCredits.setOnClickListener {

            it.findNavController().navigate(R.id.action_menuFragment_to_creditsFragment)

        }
        binding.btnFavourites.setOnClickListener {

            it.findNavController().navigate(R.id.action_menuFragment_to_pokemonFavListFragment)

        }


        // Inflate the layout for this fragment
        return binding.root
    }



}