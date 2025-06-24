package com.esa.testsetelahupdate.latihanViewModel.latihanViewModelStateFlow.ui.screen.listFriend

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.esa.testsetelahupdate.latihanViewModel.latihanViewModelStateFlow.data.repository.FriendsRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FriendViewModel(private val repository: FriendsRepository = FriendsRepository()): ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading : StateFlow<Boolean> = _isLoading

    private val _listFriend = MutableStateFlow(repository.getListFriend())
    val listFriend : StateFlow<List<String>> = _listFriend

    fun addFriend(newName : String){
        viewModelScope.launch {
            _isLoading.value = true
            delay(1000)
            _listFriend.value = repository.addFriend(newName)
            _isLoading.value = false
        }
    }
}