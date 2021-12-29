package com.canonal.creaturemon.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.canonal.creaturemon.databinding.ItemCreatureListBinding
import com.canonal.creaturemon.model.Creature

class CreatureAdapter(
    private val creatureList: MutableList<Creature>,
) : RecyclerView.Adapter<BaseViewHolder>() {

    private lateinit var binding: ItemCreatureListBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        binding =
            ItemCreatureListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CreatureViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val creature = creatureList[position]
        (holder as CreatureViewHolder).bind(creature)
    }

    override fun getItemCount() = creatureList.size

    fun getCreatureAt(position: Int): Creature = creatureList[position]

    fun removeAt(position: Int) {
        creatureList.removeAt(position)
        notifyItemRemoved(position)
    }
}