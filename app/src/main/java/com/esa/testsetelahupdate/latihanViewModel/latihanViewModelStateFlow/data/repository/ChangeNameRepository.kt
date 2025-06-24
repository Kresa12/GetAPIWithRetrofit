package com.esa.testsetelahupdate.latihanViewModel.latihanViewModelStateFlow.data.repository

class ChangeNameRepository{

    private var name = "Fika"

    fun getName(): String = name

    fun setName(newName : String): String{
        name = newName
        return newName
    }
}