package com.canonal.creaturemon.ui.viewModel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canonal.creaturemon.model.Creature
import com.canonal.creaturemon.model.CreatureAttributeGenerator
import com.canonal.creaturemon.model.CreatureGenerator
import com.canonal.creaturemon.model.attributeType.EnduranceType
import com.canonal.creaturemon.model.attributeType.IntelligenceType
import com.canonal.creaturemon.model.attributeType.StrengthType
import com.canonal.creaturemon.repository.CreatureRepository
import kotlinx.coroutines.launch

class AddCreatureViewModel(
    private val creatureRepository: CreatureRepository
) : ViewModel() {

    val creatureName = MutableLiveData<String>()
    val generateButtonVisibility = Transformations.map(creatureName) {
        if (it.length >= 3) {
            View.VISIBLE
        } else {
            View.INVISIBLE
        }
    }

    fun insertCreature(creature: Creature) {
        viewModelScope.launch {
            creatureRepository.insertCreature(creature)
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
    fun getNewCreature(
        creatureName: String,
        selectedIntelligenceItem: IntelligenceType,
        selectedStrengthItem: StrengthType,
        selectedEnduranceItem: EnduranceType,
        selectedAvatarUrl: String
    ): Creature =
        CreatureGenerator.generateCreature(
            CreatureAttributeGenerator.generateCreatureAttribute(
                selectedIntelligenceItem,
                selectedStrengthItem,
                selectedEnduranceItem
            ),
            creatureName,
            selectedAvatarUrl
        )
}