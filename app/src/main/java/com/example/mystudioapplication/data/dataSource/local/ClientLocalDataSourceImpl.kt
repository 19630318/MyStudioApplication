package com.example.mystudioapplication.data.dataSource.local

import com.example.mystudioapplication.data.dataSource.local.dao.ClientDao
import com.example.mystudioapplication.data.dataSource.local.entity.ClientEntity
import com.example.mystudioapplication.domain.model.Client

class ClientLocalDataSourceImpl(private val clientDao: ClientDao): ClientLocalDataSource {

    override suspend fun create(clientEntity: ClientEntity) = clientDao.insert(clientEntity)

    override suspend fun searchClient(email: String, password: String): ClientEntity {
        return clientDao.searchClient(email, password)
    }


}