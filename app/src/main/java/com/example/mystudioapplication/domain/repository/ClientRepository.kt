package com.example.mystudioapplication.domain.repository

import com.example.mystudioapplication.domain.model.Client
import com.example.mystudioapplication.domain.util.Resource

interface ClientRepository {

    suspend fun create(client: Client ): Resource<Client>

    suspend fun searchClient(email: String, password: String): Resource<Client>

}