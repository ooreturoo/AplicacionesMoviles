package com.sergio.pokedex.lists

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.sergio.pokedex.R
import com.sergio.pokedex.databinding.FragmentDetailFavPokemonBinding
import com.sergio.pokedex.lists.pokedex.provider.PokemonProvider


class DetailFavPokemonFragment : Fragment() {

    private lateinit var binding : FragmentDetailFavPokemonBinding

    private val args : DetailFavPokemonFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailFavPokemonBinding.inflate(inflater,container,false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pos = args.position

        val pokemon = PokemonProvider.pokemonFavList[pos]
        binding.tvDetPokemonName.text = pokemon.name
        binding.ivDetPokemon.setImageResource(pokemon.image)
        binding.ivDetCaught.visibility = View.VISIBLE
        binding.ivDetType2.visibility = View.GONE
        binding.tvDetPokedexNum.text = view.resources.getString(R.string.pokedex_number_text, pokemon.pokedexIndex)
        binding.tvDetHeight.text = view.resources.getString(R.string.detail_height_text,pokemon.height)
        binding.tvDetWeight.text = view.resources.getString(R.string.detail_weight_text, pokemon.weight)
        binding.tvDetCatchProbability.text = view.resources.getString(R.string.detail_catch_probability,pokemon.catchProbability)
        binding.ivDetType1.setImageResource(R.drawable.icon_fire_type)
        binding.ivDetType2.visibility = View.GONE
        binding.tvUserComment.text = "--Example comment added by User--"
        binding.floatingActionBtn.setOnClickListener {

            Toast.makeText(view.context,"Comment added", Toast.LENGTH_SHORT).show()

        }
    }


}