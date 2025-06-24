package com.esa.testsetelahupdate.latihanretrofit.data.repository

import com.esa.testsetelahupdate.latihanretrofit.data.api.ApiClient
import com.esa.testsetelahupdate.latihanretrofit.data.api.ApiService
import com.esa.testsetelahupdate.latihanretrofit.data.model.UserModel

class UserRepository(private val api : ApiService = ApiClient.apiService) {

    suspend fun getUsers(): List<UserModel>{
        return api.getUsers()
    }
}