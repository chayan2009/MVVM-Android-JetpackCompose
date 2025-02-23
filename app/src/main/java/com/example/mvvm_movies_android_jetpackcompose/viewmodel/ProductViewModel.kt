package com.example.mvvm_movies_android_jetpackcompose.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_movies_android_jetpackcompose.data.model.ProductResponse
import com.example.mvvm_movies_android_jetpackcompose.data.repository.ProductRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: ProductRepositoryImpl = ProductRepositoryImpl(RetrofitInstance.apiService)) : ViewModel() {

    private val _productState = MutableStateFlow<List<ProductResponse>?>(null)
    val productState: StateFlow<List<ProductResponse>?> = _productState

    fun fetchProducts() {
        viewModelScope.launch {
            try {
                val response = repository.fetchProductList()
                _productState.value = response
            } catch (e: Exception) {
                e.printStackTrace()
                _productState.value = null
            }
        }
    }
}
