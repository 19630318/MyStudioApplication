package com.example.mystudioapplication.presentation.screens.auth.register

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mystudioapplication.R
import com.example.mystudioapplication.presentation.components.DefaultTopBar
import com.example.mystudioapplication.presentation.screens.auth.login.LoginViewModel
import com.example.mystudioapplication.presentation.screens.auth.register.components.Register
import com.example.mystudioapplication.presentation.screens.auth.register.components.RegisterContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navHostController: NavHostController, vm: LoginViewModel = hiltViewModel()) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = stringResource(R.string.register_title),
                navHostController = navHostController,
                upAvailable = true
            )
        }
    ) { paddingValues ->
        RegisterContent(paddingValues)
    }
    Register(navHostController)
}