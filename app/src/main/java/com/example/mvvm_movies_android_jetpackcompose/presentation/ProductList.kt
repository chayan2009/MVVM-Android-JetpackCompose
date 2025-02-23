package com.example.mvvm_movies_android_jetpackcompose.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mvvm_movies_android_jetpackcompose.data.model.ProductResponse

@Composable
fun ProductList(productList: List<ProductResponse>?,onProductClick:(ProductResponse)->Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            productList == null -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            productList.isEmpty() -> {
                Text(
                    text = "No product found",
                    modifier = Modifier.align(Alignment.Center),
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            else -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize().padding(0.dp,80.dp),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(productList) { productResponse ->
                        ProductCard(productResponse){
                            onProductClick(it)
                        }
                    }
                }
            }
        }
    }
}
