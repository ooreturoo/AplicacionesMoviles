package com.sergio.pokedex.lists.pokedex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sergio.pokedex.databinding.FragmentPokemonListBinding
import com.sergio.pokedex.lists.pokedex.adapter.PokemonListAdapter
import com.sergio.pokedex.lists.pokedex.provider.PokemonProvider


class PokemonListFragment : Fragment() {

    private lateinit var binding : FragmentPokemonListBinding
    private lateinit var adapter: PokemonListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokemonListBinding.inflate(inflater, container,false)
        adapter = PokemonListAdapter(PokemonProvider.pokemonList, onClickStar = { pos -> onClickStar(pos)})
        binding.recyclerPokedex.adapter = adapter
        binding.recyclerPokedex.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        return binding.root

    }

    private fun onClickStar(pos : Int){

        val pokemon = PokemonProvider.pokemonList[pos]

        if (pokemon.favourite){

            PokemonProvider.pokemonFavList.add(pokemon)

        }else{

            PokemonProvider.pokemonFavList.remove(pokemon)

        }

        adapter.notifyItemChanged(pos)

    }



}