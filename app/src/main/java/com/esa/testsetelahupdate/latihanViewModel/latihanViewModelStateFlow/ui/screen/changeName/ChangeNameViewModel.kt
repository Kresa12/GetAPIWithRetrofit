package com.esa.testsetelahupdate.latihanViewModel.latihanViewModelStateFlow.ui.screen.changeName

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esa.testsetelahupdate.latihanViewModel.latihanViewModelStateFlow.data.repository.ChangeNameRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ChangeNameViewModel(private val repository : ChangeNameRepository = ChangeNameRepository()): ViewModel(){

    private val _name = MutableStateFlow(repository.getName())
    val name : StateFlow<String> = _name

    fun setName(newName : String){
        viewModelScope.launch {
            _name.value = repository.setName(newName)
        }
    }
}