package com.canonal.creaturemon.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.canonal.creaturemon.databinding.ItemAvatarListBinding
import com.canonal.creaturemon.data.remote.response.Character

class AvatarAdapter(
    private val avatarList: List<Character>,
    private val onAvatarClick: (String) -> Unit
) : RecyclerView.Adapter<BaseViewHolder>() {

    private lateinit var binding: ItemAvatarListBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        binding = ItemAvatarListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AvatarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val avatar = avatarList[position]
        (holder as AvatarViewHolder).bind(avatar, onAvatarClick)
    }

    override fun getItemCount(): Int = avatarList.size

}