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

    private val _errorMessage: MutableLiveData<String> = MutableLiveData()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    private val _characterList: MutableLiveData<List<Character>> = MutableLiveData()
    val characterList: LiveData<List<Character>>
        get() = _characterList

    fun getCharacterList(
        idList: String
    ) {
        viewModelScope.launch {
            _characterList.value =
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
