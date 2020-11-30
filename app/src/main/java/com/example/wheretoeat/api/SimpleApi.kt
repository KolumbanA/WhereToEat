package com.example.wheretoeat.api

import com.example.wheretoeat.model.ApiResponse
import com.example.wheretoeat.model.Restaurant
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("restaurants?name=ab")
    suspend fun getPost(): Response<ApiResponse>
}