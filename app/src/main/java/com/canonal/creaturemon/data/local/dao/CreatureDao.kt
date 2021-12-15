package com.canonal.creaturemon.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.canonal.creaturemon.model.Creature

@Dao
interface CreatureDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCreature(creature: Creature)

    @Query("DELETE FROM creature_table")
    suspend fun deleteAllCreatures()

    @Query("SELECT * FROM creature_table ORDER BY name ASC")
    fun getAllCreatures(): LiveData<List<Creature>>

}