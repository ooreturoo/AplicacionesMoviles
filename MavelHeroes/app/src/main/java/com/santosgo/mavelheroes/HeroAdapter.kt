package com.santosgo.mavelheroes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.santosgo.mavelheroes.data.Hero
import com.santosgo.mavelheroes.databinding.HeroItemBinding

//Clase que implementa el adaptador (Adapter), por lo que debe implementar los métodos.
class HeroAdapter(
    private val heroList : MutableList<Hero>,
    private val onClickDelete: (Int) -> Unit,
    private val onClickImage: (Int, Hero) -> Unit
) : RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {

    companion object {
        const val DRAWABLE = "drawable"
        const val CLON = "Clon"
    }

    class HeroViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        private val binding = HeroItemBinding.bind(view)

        //función para enlazar datos de cada elemento con su interfaz. Aquí se incluyen los listeners.
        fun bind(
            hero: Hero,
            onClickDelete: (Int) -> Unit,
            onClickImage: (Int, Hero) -> Unit
        ) {
            binding.tvName.text = hero.name
            binding.tvIntelligence.text = hero.intelligence.toString()
            binding.tvPower.text = hero.power.toString()
            //tomar fotos de drawable...
            val context = binding.ivPhoto.context
            val idPhoto = context.resources.getIdentifier(hero.photo, DRAWABLE,context.packageName)
            binding.ivPhoto.setImageResource(idPhoto)


            binding.root.setOnClickListener {
                Snackbar.make(it,context.getString(R.string.convocate_hero,hero.name),Snackbar.LENGTH_SHORT).show()
            }

            //borrado de un elemento de la lista con función lambda.
            binding.ivDelHero.setOnClickListener {
                onClickDelete(adapterPosition)
            }

            //Crea un clon de un héroe en una posición después del actual.
            binding.ivPhoto.setOnClickListener {
                if(!hero.name.contains(CLON)) {
                    val clonHero = hero.copy(name = "$CLON ${hero.name}")
                    onClickImage(adapterPosition+1, clonHero)
                } else {
                    Snackbar.make(it,context.getString(R.string.cant_clone), Snackbar.LENGTH_SHORT).show()
                }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroViewHolder(layoutInflater.inflate(R.layout.hero_item,parent,false))
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val hero = heroList[position]
        holder.bind(hero, onClickDelete, onClickImage)

    }

    override fun getItemCount(): Int {
        return heroList.size
    }

}