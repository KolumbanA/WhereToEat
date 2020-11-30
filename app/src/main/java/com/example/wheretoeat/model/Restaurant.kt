package com.example.wheretoeat.model

data class ApiResponse (
    val total_entries: Int,
    val per_page: Int,
    val current_page: Int,
    val restaurants: List<Restaurant>
)

data class Restaurant(
    val id: Int,
    val name: String,
    val address: String,
    val city: String,
    val state: String,
    val area: String,
    val postal_code: String,
    val country: String,
    val phone: String,
    val lat: Float,
    val lng: Float,
    val price: Int,
    val reserve_url: String,
    val mobile_reserve_url: String,
    val image_url: String
    )