package com.canonal.creaturemon.repository

import com.canonal.creaturemon.data.remote.AvatarService

class AvatarRepository(
    private val avatarService: AvatarService
) {
    fun getCharacterList(
        id1: Int,
        id2: Int,
        id3: Int,
        id4: Int,
        id5: Int,
        id6: Int,
        id7: Int,
        id8: Int,
        id9: Int,
        id10: Int,
        id11: Int,
        id12: Int,
        id13: Int,
        id14: Int,
        id15: Int
    ) = avatarService.getCharacterList(
        id1,
        id2,
        id3,
        id4,
        id5,
        id6,
        id7,
        id8,
        id9,
        id10,
        id11,
        id12,
        id13,
        id14,
        id15
    )
}