package com.example.mvvm_movies_android_jetpackcompose.data.repository

import com.example.mvvm_movies_android_jetpackcompose.data.model.ProductResponse
import com.example.mvvm_movies_android_jetpackcompose.data.network.ProductApiService

class ProductRepositoryImpl(private val apiService: ProductApiService) : ProductRepository{

    override suspend fun fetchProductList(): List<ProductResponse> {
        return apiService.getProducts().products // Ensure this returns List<ProductResponse>
    }
}
