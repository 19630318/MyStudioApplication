package com.example.mystudioapplication.data.repository

import com.example.mystudioapplication.data.dataSource.local.ClientLocalDataSource
import com.example.mystudioapplication.data.mapper.toClient
import com.example.mystudioapplication.data.mapper.toClientEntity
import com.example.mystudioapplication.domain.model.Client
import com.example.mystudioapplication.domain.repository.ClientRepository
import com.example.mystudioapplication.domain.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ClientRepositoryImpl(private val localDataSource: ClientLocalDataSource) : ClientRepository {

    override suspend fun create(client: Client): Resource<Client> {
        return try {
            localDataSource.create(client.toClientEntity())
            Resource.Success(client)
        } catch (e: Exception) {
            Resource.Failure(e.toString())
        }
    }


    override suspend fun searchClient(email: String, password: String): Resource<Client> {
        return return withContext(Dispatchers.IO) {
            try {
                val client = localDataSource.searchClient(email, password)
                Resource.Success(client.toClient())
            } catch (e: Exception) {
                Resource.Failure("Error searching for client: ${e.message}")
            }
        }
    }
}