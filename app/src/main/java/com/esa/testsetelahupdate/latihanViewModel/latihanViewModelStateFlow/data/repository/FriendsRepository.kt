package com.esa.testsetelahupdate.latihanViewModel.latihanViewModelStateFlow.data.repository

class FriendsRepository {

    private var listFriend : List<String> = listOf()

    fun getListFriend() = listFriend

    fun addFriend(newFriend : String): List<String>{
        listFriend = listFriend + newFriend
        return listFriend
    }
}