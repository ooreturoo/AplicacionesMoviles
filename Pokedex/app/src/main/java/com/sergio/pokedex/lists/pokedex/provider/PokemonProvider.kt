package com.sergio.pokedex.lists.pokedex.provider

import com.sergio.pokedex.lists.pokedex.item.PokemonItemPokedex

class PokemonProvider {

    companion object{

        val pokemonList = createList()


        private fun createList() : List<PokemonItemPokedex>{

            return listOf(

                PokemonItemPokedex( 1, "Charmander", listOf("Fuego")),
                PokemonItemPokedex( 2, "Squirtle", listOf("Agua")),
                PokemonItemPokedex( 3, "Bulbasur", listOf("Planta")),
                PokemonItemPokedex( 4, "Pikachu", listOf("Electrico")),
                PokemonItemPokedex( 5, "Pidgey", listOf("Volador")),

                )
        }

        val pokemonFavList = mutableListOf<PokemonItemPokedex>()

    }



}