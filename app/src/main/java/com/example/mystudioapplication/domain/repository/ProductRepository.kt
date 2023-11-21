package com.example.mystudioapplication.domain.repository

import com.example.mystudioapplication.domain.model.Client
import com.example.mystudioapplication.domain.model.MenuNetwork
import com.example.mystudioapplication.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    suspend fun findAllProducts(): Flow<Resource<MenuNetwork>>

}