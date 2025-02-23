package com.example.mvvm_movies_android_jetpackcompose.presentation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductToolbar(title: String?) {
    TopAppBar(
        title = {
            if (title != null) {
                Text(text = title, color = Color.White)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}
