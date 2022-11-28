package com.sergio.pokedex.lists.pokedex

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sergio.pokedex.R
import com.sergio.pokedex.databinding.FragmentPokemonItemBinding
import com.sergio.pokedex.lists.pokedex.item.PokemonItemPokedex

class PokemonListHolder(view : View) : RecyclerView.ViewHolder(view)  {

    private val binding = FragmentPokemonItemBinding.bind(view)

    private val pokemonImage = binding.pokemonImage
    private val tvPokedexPokemonNum = binding.tvPokedexPokemonNum
    private val tvPokemonName = binding.tvPokemonName
    private val tvImageType1 = binding.imageType1
    private val tvImageType2 = binding.imageType2
    private val favImageView = binding.favImageView



    fun bind(pokemon : PokemonItemPokedex, onClickStar : (Int) -> Unit){

        tvPokedexPokemonNum.text = tvPokedexPokemonNum.resources.getString(R.string.pokedex_number_text,pokemon.pokedexIndex)
        tvPokemonName.text = pokemon.name
        changeStar(pokemon)
        favImageView.setOnClickListener{

            pokemon.favourite = !pokemon.favourite
            onClickStar(absoluteAdapterPosition)

        }

        binding.root.setOnClickListener{



        }

    }

    private fun changeStar(pokemon: PokemonItemPokedex){

        if (pokemon.favourite){

            favImageView.setImageResource(R.drawable.ic_full_star)

        }else{

            favImageView.setImageResource(R.drawable.ic_empty_star)

        }

    }


}