package com.sergio.pokedex.lists.pokedex

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.sergio.pokedex.R
import com.sergio.pokedex.databinding.FragmentPokemonItemBinding
import com.sergio.pokedex.lists.pokedex.item.PokemonItemPokedex

class PokemonListHolder(view : View) : RecyclerView.ViewHolder(view)  {

    private val binding = FragmentPokemonItemBinding.bind(view)

    private val pokemonImage = binding.pokemonImage
    private val tvPokedexPokemonNum = binding.tvPokedexPokemonNum
    private val tvPokemonName = binding.tvPokemonName
    private val imageType1 = binding.ivItemType1
    private val imageType2 = binding.ivItemType2
    private val favImageView = binding.favImageView
    private val ivCaught = binding.ivPokemonCaught



    fun bind(pokemon : PokemonItemPokedex, onClickStar : (Int) -> Unit, onClickElement : (Int) -> Unit){

        tvPokedexPokemonNum.text = tvPokedexPokemonNum.resources.getString(R.string.pokedex_number_text,pokemon.pokedexIndex)
        tvPokemonName.text = pokemon.name
        pokemonImage.setImageResource(pokemon.image)
        imageType1.setImageResource(R.drawable.icon_fire_type)
        imageType2.visibility = View.GONE
        changeStar(pokemon)
        if (pokemon.caught){
            ivCaught.visibility = View.VISIBLE
        }else{
            ivCaught.visibility = View.INVISIBLE
        }
        favImageView.setOnClickListener{

            pokemon.favourite = !pokemon.favourite
            onClickStar(bindingAdapterPosition)

        }

        binding.root.setOnClickListener{

            onClickElement(bindingAdapterPosition)

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