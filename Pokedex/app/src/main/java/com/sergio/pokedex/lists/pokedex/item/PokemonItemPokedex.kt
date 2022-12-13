package com.sergio.pokedex.lists.pokedex.item

import android.graphics.drawable.Drawable


data class PokemonItemPokedex(

    val image : Int,
    val pokedexIndex : Int,
    val name : String,
    val types : List<String>,
    val caught : Boolean = false,
    val height : Int = 5,
    val weight : Int = 5,
    val catchProbability : Int = 50,
    var favourite: Boolean = false


)
