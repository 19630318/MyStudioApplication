package com.example.mystudioapplication.presentation.navigation.graph.client

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.mystudioapplication.presentation.navigation.Graph
import com.example.mystudioapplication.presentation.navigation.screen.auth.AuthScreen
import com.example.mystudioapplication.presentation.navigation.screen.client.ClientScreen
import com.example.mystudioapplication.presentation.screens.auth.login.LoginScreen
import com.example.mystudioapplication.presentation.screens.auth.login.LoginViewModel
import com.example.mystudioapplication.presentation.screens.client.home.HomeScreen


fun NavGraphBuilder.ClientNavGraph(navHostController: NavHostController){
    navigation(
        route = Graph.CLIENT,
        startDestination = ClientScreen.Home.router
    ){
        composable(route = ClientScreen.Home.router){
            HomeScreen(navHostController)
        }
    }
}