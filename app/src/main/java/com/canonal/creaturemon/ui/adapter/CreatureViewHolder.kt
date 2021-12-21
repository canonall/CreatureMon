package com.canonal.creaturemon.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.canonal.creaturemon.databinding.ItemCreatureListBinding
import com.canonal.creaturemon.model.Creature

class CreatureViewHolder(
    private val itemCreatureListBinding: ItemCreatureListBinding
) : RecyclerView.ViewHolder(itemCreatureListBinding.root) {

    fun bind(creature: Creature) {
        itemCreatureListBinding.creature = creature
    }
}