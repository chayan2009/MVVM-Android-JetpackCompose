package com.example.mvvm_movies_android_jetpackcompose.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mvvm_movies_android_jetpackcompose.data.model.ProductResponse
import com.example.mvvm_movies_android_jetpackcompose.viewmodel.ProductViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductScreen(
    navController: NavController,
    productList: List<ProductResponse>?,
    viewModel: ProductViewModel
) {
    LaunchedEffect(Unit) {
        viewModel.fetchProducts()
    }

    Scaffold(
        topBar = { ProductToolbar("Home") }
    ) {
        when {
            productList == null -> {
                // Show loading indicator
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            productList.isEmpty() -> {
                // Show message if no products are available
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "No products available")
                }
            }

            else -> {
                ProductList(productList) { product ->
                    navController.navigate("productDetails/${product.id}")
                }
            }
        }
    }
}
