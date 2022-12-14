package com.sergio.pokedex.lists.pokedex.adapter

import com.sergio.pokedex.lists.pokedex.PokemonListHolder
import com.sergio.pokedex.lists.pokedex.item.PokemonItemPokedex
import com.sergio.pokedex.lists.pokedex.provider.PokemonProvider

class PokemonFavListAdapter(
    pokemonFavList : List<PokemonItemPokedex>,
    onClickStar : (Int) -> Unit,
    onClickElement : (Int) -> Unit
    ) : ListAdapter(
    pokemonList = pokemonFavList,
    onClickStar = { pos -> onClickStar(pos)},
    onClickElement = {pos -> onClickElement(pos)}) {

    override fun onBindViewHolder(holder: PokemonListHolder, position: Int) {

        val pokemon = pokemonList[position]

        holder.bind(pokemon, onClickStar,onClickElement)

    }

    override fun getItemCount() = pokemonList.size
}