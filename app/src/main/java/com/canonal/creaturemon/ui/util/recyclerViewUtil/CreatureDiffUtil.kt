package com.canonal.creaturemon.ui.util.recyclerViewUtil

import androidx.recyclerview.widget.DiffUtil
import com.canonal.creaturemon.model.Creature

class CreatureDiffUtil: DiffUtil.ItemCallback<Creature>() {
    override fun areItemsTheSame(oldItem: Creature, newItem: Creature): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Creature, newItem: Creature): Boolean =
        oldItem == newItem
}