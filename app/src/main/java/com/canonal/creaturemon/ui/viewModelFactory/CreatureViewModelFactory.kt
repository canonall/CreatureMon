package com.canonal.creaturemon.ui.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.canonal.creaturemon.repository.CreatureRepository
import com.canonal.creaturemon.ui.viewModel.CreatureViewModel
import java.lang.IllegalArgumentException

class CreatureViewModelFactory(
    private val creatureRepository: CreatureRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CreatureViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return CreatureViewModel(creatureRepository) as T
        }
        throw IllegalArgumentException("Creature ViewModel")
    }
}