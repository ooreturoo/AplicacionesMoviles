package com.sergio.pokedex.lists.pokedex.provider

import android.view.View
import com.sergio.pokedex.R
import com.sergio.pokedex.lists.pokedex.item.PokemonItemPokedex

class PokemonProvider {

    companion object{

        val pokemonList = createList()


        private fun createList() : List<PokemonItemPokedex>{



            return listOf(

                PokemonItemPokedex(R.drawable.charmander, 1, "Charmander", listOf("Fuego"), true, favourite = true),
                PokemonItemPokedex(R.drawable.charmander, 2, "Squirtle", listOf("Agua")),
                PokemonItemPokedex(R.drawable.charmander, 3, "Bulbasur", listOf("Planta")),
                PokemonItemPokedex(R.drawable.charmander, 4, "Pikachu", listOf("Electrico"),true, favourite = true),
                PokemonItemPokedex(R.drawable.charmander, 5, "Pidgey", listOf("Volador"),true, favourite = true),

                )
        }

        val pokemonFavList = mutableListOf<PokemonItemPokedex>(pokemonList[0],pokemonList[3],pokemonList[4])

    }



}