package com.esa.testsetelahupdate.latihanretrofit.screen.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esa.testsetelahupdate.latihanretrofit.data.model.UserModel
import com.esa.testsetelahupdate.latihanretrofit.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository = UserRepository()):ViewModel() {

    private val _users = MutableStateFlow<List<UserModel>>(emptyList())
    val users : StateFlow<List<UserModel>> = _users

//    private val _isLoading = MutableStateFlow(false)
//    val isLoading: StateFlow<Boolean> = _isLoading

    fun fetchUsers(){
        viewModelScope.launch {
//            _isLoading.value = true
//            try {
//                val result = repository.getUsers()
//                _users.value = result
//            }catch (e : Exception){
//                e.printStackTrace()
//            }finally {
//                /*_isLoading.value = false*/
//            }

            val result = repository.getUsers()
            _users.value = result
        }
    }
}