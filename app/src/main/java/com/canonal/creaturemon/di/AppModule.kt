package com.canonal.creaturemon.di

import android.content.Context
import com.canonal.creaturemon.data.local.CreatureDatabase
import com.canonal.creaturemon.repository.CreatureRepository

object AppModule {

    fun getCreatureRepository(context: Context): CreatureRepository {
        val creatureDao = CreatureDatabase.getDatabase(context).creatureDao()
        return CreatureRepository(creatureDao)
    }
}