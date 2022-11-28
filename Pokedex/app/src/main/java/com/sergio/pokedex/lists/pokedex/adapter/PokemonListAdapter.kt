package com.sergio.pokedex.lists.pokedex.adapter


import com.sergio.pokedex.lists.pokedex.PokemonListHolder
import com.sergio.pokedex.lists.pokedex.item.PokemonItemPokedex

class PokemonListAdapter(
    private val pokemonList : List<PokemonItemPokedex>,
    private val onClickStar : (Int) -> Unit
    ) : ListAdapter() {

    override fun onBindViewHolder(holder: PokemonListHolder, position: Int) {

        val pokemon = pokemonList[position]
        holder.bind(pokemon, onClickStar)

    }

    override fun getItemCount() = pokemonList.size

}