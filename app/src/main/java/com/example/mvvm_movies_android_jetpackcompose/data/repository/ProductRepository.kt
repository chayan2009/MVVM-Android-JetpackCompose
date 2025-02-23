package com.example.mvvm_movies_android_jetpackcompose.data.repository

import com.example.mvvm_movies_android_jetpackcompose.data.model.ProductResponse

interface ProductRepository {
    suspend fun fetchProductList(): List<ProductResponse>
}
