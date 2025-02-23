package com.example.mvvm_movies_android_jetpackcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mvvm_movies_android_jetpackcompose.presentation.ProductDetailsScreen
import com.example.mvvm_movies_android_jetpackcompose.presentation.ProductScreen
import com.example.mvvm_movies_android_jetpackcompose.ui.theme.MVVMMoviesAndroidJetpackComposeTheme
import com.example.mvvm_movies_android_jetpackcompose.viewmodel.ProductViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val viewModel: ProductViewModel = viewModel() // Single ViewModel instance
            val productList by viewModel.productState.collectAsState()

            MVVMMoviesAndroidJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    NavHost(navController, startDestination = "productScreen") {
                        composable("productScreen") {
                            ProductScreen(navController, productList, viewModel)
                        }
                        composable(
                            "productDetails/{productId}",
                            arguments = listOf(navArgument("productId") { type = NavType.IntType })
                        ) { backStackEntry ->
                            val productId = backStackEntry.arguments?.getInt("productId")

                            when {
                                productList == null -> {
                                    // Show Loading Indicator
                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        CircularProgressIndicator()
                                    }
                                }

                                productList!!.isEmpty() -> {
                                    Text(text = "No products available", modifier = Modifier.padding(16.dp))
                                }

                                else -> {
                                    val product = productList!!.find { it.id == productId }
                                    product?.let {
                                        ProductDetailsScreen(it)
                                    } ?: Text(
                                        text = "Product not found",
                                        modifier = Modifier.padding(16.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MVVMMoviesAndroidJetpackComposeTheme {}
}
