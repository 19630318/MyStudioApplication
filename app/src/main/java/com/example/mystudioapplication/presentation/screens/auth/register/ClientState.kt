package com.example.mystudioapplication.presentation.screens.auth.register

data class ClientState (
    val id: Int = 0,
    val name: String = "",
    val lastName: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    )