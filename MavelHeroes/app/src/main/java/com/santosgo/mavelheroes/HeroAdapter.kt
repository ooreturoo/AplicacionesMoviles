package com.santosgo.mavelheroes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.santosgo.mavelheroes.data.Hero
import com.santosgo.mavelheroes.databinding.HeroItemBinding
import java.security.PrivateKey

class HeroAdapter(
    private var heroList : MutableList<Hero>,
    private val onClickDelete : (Int) -> Unit,
    private val onClickClon : (Int) -> Unit
    ) : RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {

    companion object{

        const val DRAWABLE = "drawable"

    }

    class HeroViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        private val binding = HeroItemBinding.bind(itemView)

        fun bind(hero : Hero,
                 onClickDelete: (Int) -> Unit,
                 onClickClon : (Int) -> Unit
        ){

            val context = binding.ivPhoto.context

            binding.tvName.text = hero.name
            binding.tvPower.text = hero.power.toString()
            binding.tvIntelligence.text = hero.intelligence.toString()

            binding.ivDelHero.setOnClickListener{

                onClickDelete(adapterPosition)

            }
            binding.ivPhoto.setOnClickListener{

                onClickClon(adapterPosition)

            }

            val idRes = context.resources.getIdentifier(hero.photo, DRAWABLE, context.packageName)
            binding.ivPhoto.setImageResource(idRes)

            binding.root.setOnClickListener{
                Snackbar.make(it,context.getString(R.string.call_hero,hero.name),Snackbar.LENGTH_SHORT).show()
            }

        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroViewHolder(layoutInflater.inflate(R.layout.hero_item,parent,false))
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val hero = heroList[position]
        holder.bind(hero,onClickDelete,onClickClon)
    }

    override fun getItemCount(): Int {
        return heroList.size
    }
}