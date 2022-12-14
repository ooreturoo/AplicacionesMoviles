package com.sergio.pokedex.lists.pokedex.adapter


import com.sergio.pokedex.lists.pokedex.PokemonListHolder
import com.sergio.pokedex.lists.pokedex.item.PokemonItemPokedex

class PokemonListAdapter(
    pokemonList : List<PokemonItemPokedex>,
    onClickStar : (Int) -> Unit,
    onClickElement : (Int) -> Unit
) : ListAdapter(
    pokemonList = pokemonList,
    onClickStar = { pos -> onClickStar(pos)},
    onClickElement = {pos -> onClickElement(pos)})  {

    override fun onBindViewHolder(holder: PokemonListHolder, position: Int) {

        val pokemon = pokemonList[position]
        holder.bind(pokemon, onClickStar, onClickElement)

    }

    override fun getItemCount() = pokemonList.size

}