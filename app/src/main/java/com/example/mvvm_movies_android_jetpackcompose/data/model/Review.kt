package com.example.mvvm_movies_android_jetpackcompose.data.model

data class Review(
    val rating: Int,
    val comment: String,
    val date: String,
    val reviewerName: String?,
    val reviewerEmail: String
)