package com.canonal.creaturemon.ui.adapter

import com.canonal.creaturemon.data.remote.response.Character
import com.canonal.creaturemon.databinding.ItemAvatarListBinding

class AvatarViewHolder(
    val binding: ItemAvatarListBinding
) : BaseViewHolder(binding.root) {
    fun bind(avatar: Character) {
        binding.avatar = avatar
    }
}