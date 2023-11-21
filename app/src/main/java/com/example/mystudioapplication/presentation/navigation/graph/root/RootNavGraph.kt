package com.example.mystudioapplication.presentation.navigation.graph.root

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.example.mystudioapplication.presentation.navigation.Graph
import com.example.mystudioapplication.presentation.navigation.graph.auth.AuthNavGraph
import com.example.mystudioapplication.presentation.navigation.graph.client.ClientNavGraph

@Composable
fun RootNavGraph(navHostController: NavHostController, sharedPreferences: SharedPreferences) {
    NavHost(
        navController = navHostController,
        route = Graph.ROOT,
        startDestination = if (sharedPreferences.getBoolean("isLoggedIn", false) == true) Graph.CLIENT else Graph.AUTH
    ) {
        AuthNavGraph(navHostController)
        ClientNavGraph(navHostController)
    }
}
