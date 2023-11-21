package com.example.mystudioapplication.presentation.screens.client.home.components

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mystudioapplication.domain.util.Resource
import com.example.mystudioapplication.presentation.components.defaultProgressBar
import com.example.mystudioapplication.presentation.screens.client.home.HomeViewModel
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController

@Composable
fun GetProducts(paddingValues: PaddingValues, navHostController: NavHostController, vm: HomeViewModel = hiltViewModel()) {

    when(val response = vm.productsRespose) {
        Resource.Loading -> {
            defaultProgressBar()
        }
        is Resource.Success -> {
            HomeContent(response.data, paddingValues = paddingValues, navHostController = navHostController)
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Hubo error desconocido", Toast.LENGTH_LONG).show()
            }
        }
    }
}