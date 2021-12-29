package com.canonal.creaturemon.ui.adapter

import com.canonal.creaturemon.databinding.ItemCreatureListBinding
import com.canonal.creaturemon.model.Creature

class CreatureViewHolder(
    val binding: ItemCreatureListBinding
) : BaseViewHolder(binding.root) {
    fun bind(creature: Creature) {
        binding.creature = creature
    }
}