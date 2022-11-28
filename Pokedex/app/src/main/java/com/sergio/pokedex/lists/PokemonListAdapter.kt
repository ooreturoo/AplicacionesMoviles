package com.sergio.pokedex.lists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sergio.pokedex.lists.provider.PokemonProvider

class PokemonListAdapter : RecyclerView.Adapter<PokemonListHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.l)
    }

    override fun onBindViewHolder(holder: PokemonListHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = PokemonProvider.pokemonList.size

}