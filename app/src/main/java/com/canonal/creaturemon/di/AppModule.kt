package com.canonal.creaturemon.di

import android.content.Context
import com.canonal.creaturemon.data.local.CreatureDatabase
import com.canonal.creaturemon.data.remote.RetrofitClient
import com.canonal.creaturemon.data.remote.AvatarService
import com.canonal.creaturemon.repository.AvatarRepository
import com.canonal.creaturemon.repository.CreatureRepository

object AppModule {

    fun getCreatureRepository(context: Context): CreatureRepository {
        val creatureDao = CreatureDatabase.getDatabase(context).creatureDao()
        return CreatureRepository(creatureDao)
    }

    fun getAvatarRepository(): AvatarRepository{
        val retrofit = RetrofitClient.getRetrofitInstance()
        val rickAndMortyApi = retrofit.create(AvatarService::class.java)
        return AvatarRepository(rickAndMortyApi)
    }
}