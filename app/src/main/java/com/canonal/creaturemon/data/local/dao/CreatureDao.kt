package com.canonal.creaturemon.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.canonal.creaturemon.model.Creature

@Dao
interface CreatureDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCreature(creature: Creature)

    @Delete
    suspend fun deleteCreature(creature: Creature)

    @Query("DELETE FROM creature_table")
    suspend fun deleteAllCreatures()

    @Query("SELECT * FROM creature_table ORDER BY hitPoint ASC")
    fun getAllCreatures(): LiveData<MutableList<Creature>>

}