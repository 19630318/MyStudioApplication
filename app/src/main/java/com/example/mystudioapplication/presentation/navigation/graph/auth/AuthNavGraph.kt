package com.example.mystudioapplication.presentation.navigation.graph.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.mystudioapplication.presentation.navigation.Graph
import com.example.mystudioapplication.presentation.navigation.graph.client.ClientNavGraph
import com.example.mystudioapplication.presentation.navigation.screen.auth.AuthScreen
import com.example.mystudioapplication.presentation.screens.auth.login.LoginScreen
import com.example.mystudioapplication.presentation.screens.auth.register.RegisterScreen

fun NavGraphBuilder.AuthNavGraph(navHostController: NavHostController) {
    navigation(route = Graph.AUTH, startDestination = AuthScreen.Login.router) {
        composable(route = AuthScreen.Login.router) {
            LoginScreen(navHostController)
        }
        composable(route = AuthScreen.Register.router) {
            RegisterScreen(navHostController)
        }
    }
}
