package com.sergio.pokedex.lists

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.sergio.pokedex.R
import com.sergio.pokedex.databinding.FragmentDetailPokemonBinding
import com.sergio.pokedex.databinding.FragmentPokemonItemBinding
import com.sergio.pokedex.lists.item.PokemonItemPokedex

class PokemonListHolder(view : View) : RecyclerView.ViewHolder(view)  {

    private val binding = FragmentPokemonItemBinding.bind(view)

    private val pokemonImage = binding.pokemonImage
    private val tvPokedexPokemonNum = binding.tvPokedexPokemonNum
    private val tvPokemonName = binding.tvPokemonName
    private val tvImageType1 = binding.imageType1
    private val tvImageType2 = binding.imageType2



    fun render(pokemon : PokemonItemPokedex){

        tvPokedexPokemonNum.text = pokemon.pokedexIndex.toString()
        tvPokemonName.text = pokemon.name

    }


    private fun setTypeImages(types : List<String>){

    }

}