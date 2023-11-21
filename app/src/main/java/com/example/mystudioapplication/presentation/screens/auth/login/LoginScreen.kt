package com.example.mystudioapplication.presentation.screens.auth.login

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mystudioapplication.presentation.screens.auth.login.components.Login
import com.example.mystudioapplication.presentation.screens.auth.login.components.LoginContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navHostController: NavHostController, vm: LoginViewModel = hiltViewModel()){
    Scaffold(){
            paddingValues ->  LoginContent(paddingValues, navHostController)
    }
    Login(navHostController)
}