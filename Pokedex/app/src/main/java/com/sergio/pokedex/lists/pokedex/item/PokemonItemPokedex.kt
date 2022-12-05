package com.sergio.pokedex.lists.pokedex.item

import android.graphics.drawable.Drawable


data class PokemonItemPokedex(

    val image : Int,
    val pokedexIndex : Int,
    val name : String,
    val types : List<String>,
    val caught : Boolean = false,
    //val height : Int,
    //val weight : Int,
    //val catchProbability : Int,
    var favourite: Boolean = false


)
