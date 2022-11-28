package com.sergio.pokedex.lists.provider

import com.sergio.pokedex.lists.item.PokemonItemPokedex

class PokemonProvider {

    companion object{

        val pokemonList = createList()


        private fun createList() : List<PokemonItemPokedex>{

            return listOf(

                PokemonItemPokedex( 1, "Charmander", listOf("Fuego"), 3,5),
                PokemonItemPokedex( 2, "Squirtle", listOf("Agua"), 3,7),
                PokemonItemPokedex( 3, "Bulbasur", listOf("Planta"), 3,8),
                PokemonItemPokedex( 4, "Pikachu", listOf("Electrico"), 7,9),
                PokemonItemPokedex( 5, "Pidgey", listOf("Volador"), 4,5),

                )
        }
    }



}