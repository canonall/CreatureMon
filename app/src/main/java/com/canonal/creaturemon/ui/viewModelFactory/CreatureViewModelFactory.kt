package com.canonal.creaturemon.ui.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.canonal.creaturemon.repository.CreatureRepository
import com.canonal.creaturemon.ui.viewModel.AddCreatureViewModel
import com.canonal.creaturemon.ui.viewModel.CreatureViewModel

class CreatureViewModelFactory(
    private val creatureRepository: CreatureRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CreatureViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CreatureViewModel(creatureRepository) as T
        }
        if (modelClass.isAssignableFrom(AddCreatureViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AddCreatureViewModel(creatureRepository) as T
        }
        throw IllegalArgumentException("Creature ViewModel")
    }
}