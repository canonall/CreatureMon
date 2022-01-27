package com.canonal.creaturemon.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.canonal.creaturemon.data.remote.response.Character
import com.canonal.creaturemon.databinding.ItemAvatarListBinding

class AvatarViewHolder(
    val binding: ItemAvatarListBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(character: Character, onAvatarClick: (String) -> Unit) {
        binding.avatar = character
        binding.ivAvatar.setOnClickListener {
            onAvatarClick.invoke(character.image)
        }
    }
}