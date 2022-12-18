package com.santosgo.mavelheroes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.santosgo.mavelheroes.data.Datasource
import com.santosgo.mavelheroes.data.Hero
import com.santosgo.mavelheroes.databinding.FragmentHeroListBinding


class HeroListFragment : Fragment() {

    private var _binding : FragmentHeroListBinding? = null
    val binding
        get() = _binding!!

    private var listaHeroes = Datasource.getHeroList()
    private lateinit var heroAdapter : HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHeroListBinding.inflate(inflater,container,false)

        //texto inicial
        binding.textView.text = getString(R.string.hero_list)
        initRecView()

        return binding.root
    }

    private fun initRecView() {
        heroAdapter = HeroAdapter(listaHeroes,
            onClickDelete = {  pos -> deleteHero(pos) },
            onClickImage = { pos, hero -> clonHero(pos,hero)}
        )
        binding.rvHeroes.adapter = heroAdapter
        binding.rvHeroes.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    //borra un heroe de la lista y notifica al adapter.
    private fun deleteHero(pos : Int) {
        listaHeroes.removeAt(pos)
        heroAdapter.notifyItemRemoved(pos)
    }

    //clona un heroe de la lista en la posición indicada y notifica al adapter.
    private fun clonHero(pos: Int, hero : Hero) {
        listaHeroes.add(pos,hero)
        heroAdapter.notifyItemInserted(pos)
    }

}