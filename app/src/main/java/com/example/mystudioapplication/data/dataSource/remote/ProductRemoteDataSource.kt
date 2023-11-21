package com.example.mystudioapplication.data.dataSource.remote

import com.example.mystudioapplication.domain.model.MenuNetwork
import retrofit2.Response

interface ProductRemoteDataSource {

    suspend fun findAll(): Response<MenuNetwork>

}