package com.example.mvvm_movies_android_jetpackcompose.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.mvvm_movies_android_jetpackcompose.data.model.ProductResponse

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductDetailsScreen(product: ProductResponse) {

    Scaffold(
        topBar = { ProductToolbar(product.title) }
    ) {
        when {
            false -> {
                // Show loading indicator
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            else -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp).verticalScroll(rememberScrollState())
                ) {

                    Image(
                        painter = rememberAsyncImagePainter(product.thumbnail),
                        contentDescription = product.title,
                        modifier = Modifier
                            .fillMaxWidth().padding(0.dp,20.dp)
                            .weight(0.6f),
                        contentScale = ContentScale.Crop
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(20.dp),
                        verticalArrangement = Arrangement.Center
                    ) {

                        Text(
                            text = product.title ?: "Unknown Product",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Category: ${product.category}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = if (product.stock > 0) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Price: ${product.price}$",
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Stock: ${product.stock}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = if (product.stock > 0) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
                        )

                        Text(
                            text = "Brand: ${product.brand}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = if (product.stock > 0) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
                        )


                        Text(
                            text = "Description: ${product.description}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = if (product.stock > 0) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
                        )

                    }
                }
            }
        }
    }

}