package com.example.mystudioapplication.data.dataSource.local

import com.example.mystudioapplication.data.dataSource.local.entity.ClientEntity
import com.example.mystudioapplication.domain.model.Client

interface ClientLocalDataSource {

    suspend fun create(clientEntity: ClientEntity)

    suspend fun searchClient(email: String, password: String): ClientEntity

}