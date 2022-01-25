package com.canonal.creaturemon.repository

import com.canonal.creaturemon.data.remote.AvatarService
import com.canonal.creaturemon.data.remote.response.Character

class AvatarRepository(
    private val avatarService: AvatarService
) {
    suspend fun getCharacterList(idList: String): List<Character> =
        avatarService.getCharacterList(idList)
}