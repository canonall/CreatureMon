package com.canonal.creaturemon.ui.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.canonal.creaturemon.repository.AvatarRepository
import com.canonal.creaturemon.ui.viewModel.AvatarViewModel

class AvatarViewModelFactory(
    private val avatarRepository: AvatarRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AvatarViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AvatarViewModel(avatarRepository) as T
        }
        throw IllegalArgumentException("Avatar ViewModel")
    }
}