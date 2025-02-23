package com.example.mvvm_movies_android_jetpackcompose.data.model

data class ProductListResponse(
    val products: List<ProductResponse>,
    val total: Int,
    val skip: Int,
    val limit: Int
)