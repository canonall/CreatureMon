package com.canonal.creaturemon.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.canonal.creaturemon.databinding.ItemCreatureListBinding
import com.canonal.creaturemon.model.Creature

class CreatureAdapter(
    private val creatureList: List<Creature>
) : RecyclerView.Adapter<CreatureViewHolder>() {

    private lateinit var itemCreatureListBinding: ItemCreatureListBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreatureViewHolder {
        itemCreatureListBinding =
            ItemCreatureListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CreatureViewHolder(itemCreatureListBinding)

    }

    override fun onBindViewHolder(holder: CreatureViewHolder, position: Int) {
        val creature = creatureList[position]
        holder.bind(creature)

    }

    override fun getItemCount() = creatureList.size
}