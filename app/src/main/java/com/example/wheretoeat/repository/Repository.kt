package com.example.wheretoeat.repository

import com.example.wheretoeat.api.RetrofitInstance
import com.example.wheretoeat.model.ApiResponse
import com.example.wheretoeat.model.Restaurant
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<ApiResponse> {
        return RetrofitInstance.api.getPost()
    }
}