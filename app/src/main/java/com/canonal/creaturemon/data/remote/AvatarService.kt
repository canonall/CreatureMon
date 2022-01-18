package com.canonal.creaturemon.data.remote

import com.canonal.creaturemon.data.remote.response.Character
import retrofit2.http.GET
import retrofit2.http.Path

interface AvatarService {

    @GET(
        "character/{id1},{id2},{id3},{id4},{id5},{id6}" +
                ",{id7},{id8},{id9},{id10},{id11},{id12},{id13}" +
                ",{id14},{id15}"
    )
    suspend fun getCharacterList(
        @Path("id1") id1: Int,
        @Path("id2") id2: Int,
        @Path("id3") id3: Int,
        @Path("id4") id4: Int,
        @Path("id5") id5: Int,
        @Path("id6") id6: Int,
        @Path("id7") id7: Int,
        @Path("id8") id8: Int,
        @Path("id9") id9: Int,
        @Path("id10") id10: Int,
        @Path("id11") id11: Int,
        @Path("id12") id12: Int,
        @Path("id13") id13: Int,
        @Path("id14") id14: Int,
        @Path("id15") id15: Int,
    ): List<Character>
}