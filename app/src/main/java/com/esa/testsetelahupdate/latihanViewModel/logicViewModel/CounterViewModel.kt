package com.esa.testsetelahupdate.latihanViewModel.logicViewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CounterRepsitory {

    private var count = 0

    fun getCount() : Int = count

    fun increment() : Int  {
        count++
        return count
    }

    fun decrement() : Int {
        count--
        return count
    }
}

class CounterViewModel(private val repository : CounterRepsitory = CounterRepsitory()) : ViewModel(){

    private val _count = MutableStateFlow(repository.getCount())
    val count : StateFlow<Int> = _count.asStateFlow()

    fun increment(){
        viewModelScope.launch {
            _count.value = repository.increment()
        }
    }

    fun decrement(){
        viewModelScope.launch {
            _count.value = repository.decrement()
        }
    }
}


//**
// code dibawah adalah contoh code yang menggunakan viewmodel untuk menyimpan logic
// beda dengan code di atas yang memisahkan antara logic dan viewmodel
// viewmodel digunakan untuk menyimpan lifecycle dari aplikasi/

//class CounterViewModel : ViewModel() {
//    private val _count = mutableStateOf(0)
//    val count: State<Int> = _count
//
//    fun increment() {
//        _count.value++
//    }
//
//    fun decrement(){
//        _count.value--
//        if (_count.value <= 0){
//            _count.value = 0
//        }
//    }
//}