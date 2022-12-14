package com.sergio.pokedex.lists.pokedex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sergio.pokedex.R
import com.sergio.pokedex.databinding.FragmentPokemonFavListBinding
import com.sergio.pokedex.lists.pokedex.adapter.PokemonFavListAdapter
import com.sergio.pokedex.lists.pokedex.item.PokemonItemPokedex
import com.sergio.pokedex.lists.pokedex.provider.PokemonProvider

class PokemonFavListFragment : Fragment() {

    private lateinit var binding: FragmentPokemonFavListBinding
    private lateinit var adapter: PokemonFavListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPokemonFavListBinding.inflate(inflater,container,false)
        adapter = PokemonFavListAdapter(PokemonProvider.pokemonFavList, onClickStar = {pos -> onClickStar(pos)}, onClickElement = {pos -> onClickElement(pos)})
        binding.recyclerFavPokedex.adapter = adapter
        binding.recyclerFavPokedex.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        return binding.root

    }

    private fun onClickStar(pos : Int){

        val pokemon = PokemonProvider.pokemonFavList[pos]

        PokemonProvider.pokemonFavList.remove(pokemon)

        Toast.makeText(context,"Pokemon is now not favourite",Toast.LENGTH_SHORT).show()

        adapter.notifyItemRemoved(pos)

    }

    private fun onClickElement(pos : Int ){

        val action = PokemonFavListFragmentDirections.actionPokemonFavListFragmentToDetailFavPokemonFragment(pos)
        findNavController().navigate(action)

    }

}