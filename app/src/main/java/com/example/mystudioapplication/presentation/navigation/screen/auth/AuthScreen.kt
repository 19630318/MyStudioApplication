package com.example.mystudioapplication.presentation.navigation.screen.auth

sealed class AuthScreen (val router:String){
    object Login: AuthScreen(router = "login")
    object Register: AuthScreen(router = "register")
}