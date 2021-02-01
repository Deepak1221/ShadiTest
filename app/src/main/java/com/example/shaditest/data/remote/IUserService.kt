package com.example.shaditest.data.remote

import com.example.shaditest.data.ui.models.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response
interface IUserService {
    @GET("/api")
    suspend fun getPerson(@Query("results") num: String) :  Response<ApiResponse>
}