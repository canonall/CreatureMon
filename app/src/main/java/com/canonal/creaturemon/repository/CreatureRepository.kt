package com.canonal.creaturemon.repository

import androidx.lifecycle.LiveData
import com.canonal.creaturemon.data.local.dao.CreatureDao
import com.canonal.creaturemon.model.Creature

class CreatureRepository(
    private val creatureDao: CreatureDao
) {
    suspend fun insertCreature(creature: Creature) = creatureDao.insertCreature(creature)
    suspend fun deleteCreature(creature: Creature) = creatureDao.deleteCreature(creature)
    suspend fun deleteAllCreatures() = creatureDao.deleteAllCreatures()
    fun getAllCreatures(): LiveData<MutableList<Creature>> = creatureDao.getAllCreatures()
}