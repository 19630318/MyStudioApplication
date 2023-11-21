package com.example.mystudioapplication.data.dataSource.remote

import com.example.mystudioapplication.data.dataSource.remote.service.ProductService
import com.example.mystudioapplication.domain.model.MenuNetwork
import retrofit2.Response

class ProductRemoteDataSourceImpl(private val productService: ProductService): ProductRemoteDataSource {
    override suspend fun findAll(): Response<MenuNetwork> = productService.findAllProducts()
}