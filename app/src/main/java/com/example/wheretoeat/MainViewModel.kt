package com.example.wheretoeat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wheretoeat.model.ApiResponse
import com.example.wheretoeat.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<ApiResponse>> = MutableLiveData()
    val myResponseRestaurantsDetailed: MutableLiveData<Response<ApiResponse>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }

    fun getRestaurantsDetailed(options: Map<String,String>){
        viewModelScope.launch {
            val response = repository.getRestaurantsDetailed(options)
            myResponseRestaurantsDetailed.value = response
        }
    }
}