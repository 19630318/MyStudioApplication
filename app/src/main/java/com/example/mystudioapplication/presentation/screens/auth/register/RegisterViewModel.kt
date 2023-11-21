package com.example.mystudioapplication.presentation.screens.auth.register

import android.content.Context
import android.content.SharedPreferences
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mystudioapplication.domain.model.Client
import com.example.mystudioapplication.domain.usecase.client.ClientUseCase
import com.example.mystudioapplication.domain.util.Resource
import com.example.mystudioapplication.presentation.screens.auth.register.mapper.toClient
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val clientUseCase: ClientUseCase,
    private val sharedPreferences: SharedPreferences,
    @ApplicationContext private val context: Context
) : ViewModel() {

    var state by mutableStateOf(ClientState())
        private set

    var bottonEnable by mutableStateOf(true)

    var errorMessage by mutableStateOf("")

    var registerResponse by mutableStateOf<Resource<Client>?>(null)
        private set

    fun register() = viewModelScope.launch {
        bottonEnable = false
        if (isValidForm()) {
            registerResponse = Resource.Loading
            Thread.sleep(1500)
            val result = clientUseCase.createClientUseCase(state.toClient())
            registerResponse = result
        }else{
            bottonEnable = true
        }
    }

    fun saveSession() {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("email", state.email)
        sharedPreferences.edit().putString("password", state.password)
    }

    fun onNameInput(name: String) {
        state = state.copy(name = name)
    }

    fun onLastNameInput(lastName: String) {
        state = state.copy(lastName = lastName)
    }

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    fun onConfirmPasswordInput(confirmPassword: String) {
        state = state.copy(confirmPassword = confirmPassword)
    }

    fun isValidForm(): Boolean {

        if (state.name == "") {
            errorMessage = "Ingresa el nombre"
            return false
        } else if (state.lastName == "") {
            errorMessage = "Ingresa los apellidos"
            return false
        } else if (state.email == "") {
            errorMessage = "Ingresa el correo electronico"
            return false
        } else if (state.password == "") {
            errorMessage = "Ingresa una contraseña"
            return false
        } else if (state.confirmPassword == "") {
            errorMessage = "Ingresa la contraseña de confirmación"
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "El email es invalido"
            return false
        } else if (state.password.length < 8) {
            errorMessage = "La contraseña debe de tener al menos 8 caracteres"
            return false
        } else if (state.password != state.confirmPassword) {
            errorMessage = "Las contraseñas no coinciden"
            return false
        }

        return true
    }

}