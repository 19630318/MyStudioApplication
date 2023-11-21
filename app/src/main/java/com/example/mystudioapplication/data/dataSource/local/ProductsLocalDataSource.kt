package com.example.mystudioapplication.data.dataSource.local

import com.example.mystudioapplication.data.dataSource.local.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

interface ProductsLocalDataSource {

    suspend fun getAll(): Flow<List<ProductEntity>>

    suspend fun insert(productEntity: ProductEntity)

}