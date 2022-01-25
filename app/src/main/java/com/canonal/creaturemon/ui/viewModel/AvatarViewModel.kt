package com.canonal.creaturemon.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canonal.creaturemon.data.remote.response.Character
import com.canonal.creaturemon.repository.AvatarRepository
import kotlinx.coroutines.launch

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
        idList: String
    ) {
        viewModelScope.launch {
            mutableCharacterList.value =
                avatarRepository.getCharacterList(
                    idList
                )
        }
    }

    //There is a total of 826 characters
    //We select randomly 15 of them
    fun getAvatarIdArray(): Array<Int> =
        arrayOf(
            1, 183, 2, 3, 5,
            8, 20, 15, 17, 124,
            254, 69, 99, 100, 11
        )
}
