package com.example.mystudioapplication.data.dataSource.local

import com.example.mystudioapplication.data.dataSource.local.dao.ProductDao
import com.example.mystudioapplication.data.dataSource.local.entity.ProductEntity
import kotlinx.coroutines.flow.Flow


class ProductsLocalDataSourceImpl(private val productDao: ProductDao): ProductsLocalDataSource {
    override suspend fun getAll(): Flow<List<ProductEntity>> = productDao.getAll()

    override suspend fun insert(productEntity: ProductEntity) = productDao.insertAll(productEntity)
}