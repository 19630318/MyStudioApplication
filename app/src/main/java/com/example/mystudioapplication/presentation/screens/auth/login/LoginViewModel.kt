package com.example.mystudioapplication.presentation.screens.auth.login

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mystudioapplication.R
import com.example.mystudioapplication.domain.model.Client
import com.example.mystudioapplication.domain.usecase.client.ClientUseCase
import com.example.mystudioapplication.domain.util.Resource
import com.example.mystudioapplication.presentation.components.showToast
import com.example.mystudioapplication.presentation.util.validateLogin
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val clientUseCase: ClientUseCase,
    private val sharedPreferences: SharedPreferences,
    @ApplicationContext private val context: Context
) : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    var bottonEnable by mutableStateOf(true)

    var loginResponse by mutableStateOf<Resource<Client>?>(null)
        private set

    fun saveLogin() = viewModelScope.launch {
        bottonEnable = false
        if (validateLogin(state.email, state.password)) {
            loginResponse = Resource.Loading
            delay(1000)
            val result = clientUseCase.searchClientUseCase(state.email, state.password)
            loginResponse = result
        } else {
            showToast(context, R.string.error_login)
            bottonEnable = true
        }
    }

    fun saveSession() {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("email", state.email)
        sharedPreferences.edit().putString("password", state.password)
    }

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

}