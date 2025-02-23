package com.example.mvvm_movies_android_jetpackcompose.data.network

import com.example.mvvm_movies_android_jetpackcompose.data.model.ProductListResponse
import retrofit2.http.GET

interface ProductApiService {

    @GET("products") // ✅ Ensure this matches your API path
    suspend fun getProducts(): ProductListResponse
}
