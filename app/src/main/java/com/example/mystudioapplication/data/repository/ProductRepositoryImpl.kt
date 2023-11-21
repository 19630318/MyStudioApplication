package com.example.mystudioapplication.data.repository

import com.example.mystudioapplication.data.dataSource.local.ProductsLocalDataSource
import com.example.mystudioapplication.data.dataSource.local.entity.ProductEntity
import com.example.mystudioapplication.data.dataSource.remote.ProductRemoteDataSource
import com.example.mystudioapplication.data.mapper.toMenuItemNetwork
import com.example.mystudioapplication.data.mapper.toMenuNetwork
import com.example.mystudioapplication.data.mapper.toProductEntity
import com.example.mystudioapplication.data.mapper.toProductEntityList
import com.example.mystudioapplication.domain.model.MenuNetwork
import com.example.mystudioapplication.domain.repository.ProductRepository
import com.example.mystudioapplication.domain.util.Resource
import com.example.mystudioapplication.domain.util.ResponseToRequest
import com.example.mystudioapplication.domain.util.isListEqual
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import java.io.IOException

class ProductRepositoryImpl(
    private val productRemoteDataSource: ProductRemoteDataSource,
    private val productsLocalDataSource: ProductsLocalDataSource
) : ProductRepository {

    override suspend fun findAllProducts(): Flow<Resource<MenuNetwork>> = flow {
        // Obtén los productos locales
        val localProducts = productsLocalDataSource.getAll().firstOrNull() ?: emptyList()

        val localMap = localProducts.map { it.toMenuItemNetwork() }
        try {
            // Obtén los productos remotos
            val remoteResponse = productRemoteDataSource.findAll()
            val remoteProducts = remoteResponse.body()

            if (remoteResponse.isSuccessful && remoteProducts != null) {
                // Inserta todos los productos remotos en la base de datos local
                remoteProducts.items.forEach { remoteItem ->
                    val entity = remoteItem.toProductEntity()
                    if (!localProducts.contains(entity)) {
                        productsLocalDataSource.insert(entity)
                    }
                }

                emit(Resource.Success(remoteProducts))
            } else {
                emit(Resource.Success(localMap.toMenuNetwork()))
            }
        } catch (e: IOException) {
            emit(Resource.Success(localMap.toMenuNetwork()))
        } catch (e: Exception) {
            emit(Resource.Failure(e.toString()))
        }
    }.flowOn(Dispatchers.IO)

}

