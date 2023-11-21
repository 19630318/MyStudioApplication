package com.example.mystudioapplication.presentation.screens.client.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mystudioapplication.R
import com.example.mystudioapplication.presentation.components.DefaultTopBar
import com.example.mystudioapplication.presentation.screens.auth.login.components.LoginContent
import com.example.mystudioapplication.presentation.screens.client.home.components.GetProducts
import com.example.mystudioapplication.presentation.screens.client.home.components.HomeContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navHostController: NavHostController, vm: HomeViewModel = hiltViewModel()) {

    //vm.getProducts()

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = stringResource(R.string.home_title),
                navHostController = navHostController,
                upAvailable = false
            )
        }
    ) {
        GetProducts(it, navHostController)
    }
}