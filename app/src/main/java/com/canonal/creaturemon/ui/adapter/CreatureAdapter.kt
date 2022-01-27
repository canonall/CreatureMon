package com.canonal.creaturemon.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.canonal.creaturemon.databinding.ItemCreatureListBinding
import com.canonal.creaturemon.model.Creature
import com.canonal.creaturemon.ui.util.recyclerViewUtil.CreatureDiffUtil

class CreatureAdapter : ListAdapter<Creature, CreatureViewHolder>(CreatureDiffUtil()) {

    private lateinit var binding: ItemCreatureListBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreatureViewHolder {
        binding =
            ItemCreatureListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CreatureViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CreatureViewHolder, position: Int) {
        val creature = currentList[position]
        holder.bind(creature)
    }
}