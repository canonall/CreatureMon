package com.canonal.creaturemon.repository

import com.canonal.creaturemon.data.remote.AvatarApi
import com.canonal.creaturemon.data.remote.response.Character

class AvatarRepository(
    private val avatarApi: AvatarApi
) {
    suspend fun getCharacterList(idList: String): List<Character> =
        avatarApi.getCharacterList(idList)
}