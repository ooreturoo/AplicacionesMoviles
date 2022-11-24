package com.santosgo.mavelheroes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.santosgo.mavelheroes.data.DataSource
import com.santosgo.mavelheroes.data.Hero
import com.santosgo.mavelheroes.databinding.FragmentHeroListBinding


class HeroListFragment : Fragment() {

    private lateinit var heroAdapter: HeroAdapter
    private lateinit var linearLayoutManager : LinearLayoutManager
    private lateinit var heroList : MutableList<Hero>
    private var _binding : FragmentHeroListBinding? = null
    val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHeroListBinding.inflate(inflater,container,false)

        //texto inicial
        val heroList = DataSource.getHeroList()
        binding.textView.text = getString(R.string.hero_list)
        for( h : Hero in heroList){

            binding.textView.text = "${binding.textView.text} \nHeroe: ${h.name}"

        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadRecyclerView()

    }

    private fun loadRecyclerView(){

        binding.textView.text = getString(R.string.hero_list)
        heroList = DataSource.getHeroList()
        heroAdapter = HeroAdapter(heroList, onClickDelete =  {pos -> delHero(pos)}, onClickClon = {pos -> clonHero(pos)})
        linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        binding.rvHeroList.adapter = heroAdapter
        binding.rvHeroList.layoutManager = linearLayoutManager

    }

    fun delHero(pos : Int){

        heroList.removeAt(pos)
        heroAdapter.notifyItemRemoved(pos)

    }

    fun clonHero(pos: Int){
        val baseHero = heroList[pos]
        if (baseHero.name.contains(getString(R.string.clon_text ,""))){

            Snackbar.make(requireView(),getString(R.string.no_clonable_text), Snackbar.LENGTH_SHORT).show()

        }else{

            var hero = Hero(getString(R.string.clon_text,baseHero.name),baseHero.power,baseHero.intelligence,baseHero.photo,baseHero.description)
            heroList.add(pos+1,hero)
            heroAdapter.notifyItemInserted(pos+1)

        }

    }
}