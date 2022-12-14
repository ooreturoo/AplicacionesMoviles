package com.sergio.pokedex.lists.pokedex.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sergio.pokedex.R
import com.sergio.pokedex.lists.pokedex.PokemonListHolder
import com.sergio.pokedex.lists.pokedex.item.PokemonItemPokedex
import com.sergio.pokedex.lists.pokedex.provider.PokemonProvider

abstract class ListAdapter (
    protected val pokemonList : List<PokemonItemPokedex>,
    protected val onClickStar : (Int) -> Unit,
    protected val onClickElement : (Int) -> Unit
        ) : RecyclerView.Adapter<PokemonListHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.fragment_pokemon_item, parent,false)
        return PokemonListHolder(view)
    }

}