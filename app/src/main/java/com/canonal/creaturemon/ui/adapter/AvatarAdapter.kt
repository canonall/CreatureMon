package com.canonal.creaturemon.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.canonal.creaturemon.data.remote.response.Character
import com.canonal.creaturemon.databinding.ItemAvatarListBinding

class AvatarAdapter(
    private val avatarList: List<Character>,
    private val onAvatarClick: (String) -> Unit
) : RecyclerView.Adapter<AvatarViewHolder>() {

    private lateinit var binding: ItemAvatarListBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvatarViewHolder {
        binding = ItemAvatarListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AvatarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AvatarViewHolder, position: Int) {
        val avatar = avatarList[position]
        holder.bind(avatar, onAvatarClick)
    }

    override fun getItemCount(): Int = avatarList.size

}