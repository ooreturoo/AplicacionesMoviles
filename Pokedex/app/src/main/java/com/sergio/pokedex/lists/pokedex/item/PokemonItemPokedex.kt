package com.sergio.pokedex.lists.pokedex.item


data class PokemonItemPokedex(

    //val image : Image,
    val pokedexIndex : Int,
    val name : String,
    val types : List<String>,
    var favourite: Boolean = false

)
