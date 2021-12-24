package com.canonal.creaturemon.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canonal.creaturemon.model.Creature
import com.canonal.creaturemon.model.attributeType.EnduranceType
import com.canonal.creaturemon.model.attributeType.IntelligenceType
import com.canonal.creaturemon.model.attributeType.StrengthType
import com.canonal.creaturemon.repository.CreatureRepository
import kotlinx.coroutines.launch

class CreatureViewModel(
    private val creatureRepository: CreatureRepository
) : ViewModel() {

    val creatureList: LiveData<List<Creature>> = creatureRepository.getAllCreatures()

    fun insertCreature(creature: Creature) {
        viewModelScope.launch {
            creatureRepository.insertCreature(creature)
        }
    }

    fun deleteAllCreatures() {
        viewModelScope.launch {
            creatureRepository.deleteAllCreatures()
        }
    }

    fun getIntelligenceTypeList() = listOf(
        IntelligenceType.SMART,
        IntelligenceType.REGULAR,
        IntelligenceType.DUMB
    )

    fun getStrengthTypeList() = listOf(
        StrengthType.STRONG,
        StrengthType.REGULAR,
        StrengthType.WEAK
    )

    fun getEnduranceTypeList() = listOf(
        EnduranceType.TOUGH,
        EnduranceType.REGULAR,
        EnduranceType.WEAK
    )
}