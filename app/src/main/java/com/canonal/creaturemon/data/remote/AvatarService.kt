package com.canonal.creaturemon.data.remote

import com.canonal.creaturemon.data.remote.response.Character
import retrofit2.http.GET
import retrofit2.http.Path

interface AvatarService {

    @GET("character/{idList}")
    suspend fun getCharacterList(
        @Path("idList") idList: String
    ): List<Character>
}