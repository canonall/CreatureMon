package com.canonal.creaturemon.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canonal.creaturemon.model.Creature
import com.canonal.creaturemon.repository.CreatureRepository
import kotlinx.coroutines.launch

class CreatureViewModel(
    private val creatureRepository: CreatureRepository
) : ViewModel() {

    val creatureList: LiveData<MutableList<Creature>> = creatureRepository.getAllCreatures()

    fun deleteCreature(creature: Creature) {
        viewModelScope.launch {
            creatureRepository.deleteCreature(creature)
        }
    }
    fun deleteAllCreatures() {
        viewModelScope.launch {
            creatureRepository.deleteAllCreatures()
        }
    }
}