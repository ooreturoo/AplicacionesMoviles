package com.sergio.pokedex.lists.pokedex.adapter


import com.sergio.pokedex.lists.pokedex.PokemonListHolder
import com.sergio.pokedex.lists.pokedex.item.PokemonItemPokedex

class PokemonListAdapter(
    private val pokemonList : List<PokemonItemPokedex>,
    private val onClickStar : (Int) -> Unit,
    private val onClickElement : (PokemonItemPokedex) -> Unit
    ) : ListAdapter() {

    override fun onBindViewHolder(holder: PokemonListHolder, position: Int) {

        val pokemon = pokemonList[position]
        holder.bind(pokemon, onClickStar, onClickElement)

    }

    override fun getItemCount() = pokemonList.size

}