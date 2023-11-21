package com.example.mystudioapplication.presentation.util

fun validateLogin(email: String, password: String): Boolean {
    return (email.isNotBlank() && password.isNotBlank() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >= 8)
}