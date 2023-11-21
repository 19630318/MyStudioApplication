package com.example.mystudioapplication.presentation.navigation.screen.client

sealed class ClientScreen (val router:String){
    object Home: ClientScreen(router = "Home")
    //object Register: ClientScreen(router = "register")
}