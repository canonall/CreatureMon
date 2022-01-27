package com.canonal.creaturemon.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.canonal.creaturemon.databinding.ItemCreatureListBinding
import com.canonal.creaturemon.model.Creature

class CreatureViewHolder(
    val binding: ItemCreatureListBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(creature: Creature) {
        binding.creature = creature
    }
}