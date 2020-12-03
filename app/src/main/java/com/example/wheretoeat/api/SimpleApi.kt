package com.example.wheretoeat.api

import com.example.wheretoeat.model.ApiResponse
import com.example.wheretoeat.model.Restaurant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface SimpleApi {

    @GET("restaurants?name=ab")
    suspend fun getPost(): Response<ApiResponse>


    @GET("restaurants")
    suspend fun getRestaurantsDetailed(
            @QueryMap options: Map<String,String >
    ): Response<ApiResponse>
}