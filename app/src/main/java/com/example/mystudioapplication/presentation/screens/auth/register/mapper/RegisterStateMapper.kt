package com.example.mystudioapplication.presentation.screens.auth.register.mapper

import com.example.mystudioapplication.domain.model.Client
import com.example.mystudioapplication.presentation.screens.auth.register.ClientState

fun ClientState.toClient(): Client {
    return Client(
        id = id,
        name = name,
        lastName = lastName,
        email = email,
        password = password
    )
}