package com.example.mvvm_movies_android_jetpackcompose.data.model

data class ProductResponse(
    val id: Int,
    val title: String?,
    val description: String?,
    val category: String?,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val tags: List<String>?,
    val brand: String?,
    val sku: String?,
    val weight: Int,
    val dimensions: Dimensions?,
    val warrantyInformation: String?,
    val shippingInformation: String?,
    val availabilityStatus: String?,
    val reviews: List<Review>?,
    val returnPolicy: String?,
    val minimumOrderQuantity: Int,
    val meta: Meta?,
    val images: List<String>?,
    val thumbnail: String?
)