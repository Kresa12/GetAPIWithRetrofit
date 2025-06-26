package com.esa.testsetelahupdate.latihanretrofit.data.api

import com.esa.testsetelahupdate.latihanretrofit.data.model.UserModel
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getUsers(): List<UserModel>
}