package com.example.mystudioapplication.presentation.screens.auth.register.components

import android.content.SharedPreferences
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mystudioapplication.domain.util.Resource
import com.example.mystudioapplication.presentation.components.defaultProgressBar
import com.example.mystudioapplication.presentation.navigation.Graph
import com.example.mystudioapplication.presentation.navigation.screen.client.ClientScreen
import com.example.mystudioapplication.presentation.screens.auth.register.RegisterViewModel

@Composable
fun Register(navHostController: NavHostController, vm: RegisterViewModel = hiltViewModel()) {

    var response = vm.registerResponse

    when (response) {
        Resource.Loading -> {
            defaultProgressBar()
        }

        is Resource.Success -> {
            Toast.makeText(LocalContext.current, "Inicio de sesion correcto", Toast.LENGTH_SHORT).show()
            LaunchedEffect(Unit) {
                vm.saveSession()
                navHostController.navigate(route = ClientScreen.Home.router) {
                    popUpTo(Graph.AUTH) {
                        inclusive = true
                    }
                }
            }
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT).show()
        }

        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Error desconocido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
