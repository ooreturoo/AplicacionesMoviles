package com.sergio.pokedex.lists.pokedex.adapter

import com.sergio.pokedex.lists.pokedex.PokemonListHolder
import com.sergio.pokedex.lists.pokedex.item.PokemonItemPokedex
import com.sergio.pokedex.lists.pokedex.provider.PokemonProvider

class PokemonFavListAdapter(
    private val pokemonFavList : List<PokemonItemPokedex>,
    private val onClickStar : (Int) -> Unit,
    private val onClickElement : (PokemonItemPokedex) -> Unit
    ) : ListAdapter() {

    override fun onBindViewHolder(holder: PokemonListHolder, position: Int) {

        val pokemon = pokemonFavList[position]

        holder.bind(pokemon, onClickStar,onClickElement)

    }

    override fun getItemCount() = pokemonFavList.size
}