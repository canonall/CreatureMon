package com.canonal.creaturemon.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.canonal.creaturemon.data.remote.response.Character
import com.canonal.creaturemon.repository.AvatarRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AvatarViewModel(
    private val avatarRepository: AvatarRepository
) : ViewModel() {


    private val mutableErrorMessage: MutableLiveData<String> = MutableLiveData()
    val errorMessage: LiveData<String>
        get() = mutableErrorMessage

    private val mutableCharacterList: MutableLiveData<List<Character>> = MutableLiveData()
    val characterList: LiveData<List<Character>>
        get() = mutableCharacterList

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
    ) {
        val response = avatarRepository.getCharacterList(
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
        response.enqueue(object : Callback<List<Character>> {
            override fun onResponse(
                call: Call<List<Character>>,
                response: Response<List<Character>>
            ) {
                mutableCharacterList.value = response.body()
            }

            override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                mutableErrorMessage.value = t.message
            }

        })
    }

}