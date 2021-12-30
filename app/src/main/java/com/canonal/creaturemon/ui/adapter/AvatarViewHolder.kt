package com.canonal.creaturemon.ui.adapter

import com.canonal.creaturemon.data.remote.response.Character
import com.canonal.creaturemon.databinding.ItemAvatarListBinding

class AvatarViewHolder(
    val binding: ItemAvatarListBinding
) : BaseViewHolder(binding.root) {
    fun bind(character: Character, onAvatarClick: (String)-> Unit) {
        binding.avatar = character
        binding.ivAvatar.setOnClickListener{
            onAvatarClick.invoke(character.image)
        }
    }
}