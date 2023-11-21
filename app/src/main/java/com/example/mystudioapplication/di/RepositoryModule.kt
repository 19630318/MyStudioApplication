package com.example.mystudioapplication.di

import com.example.mystudioapplication.data.dataSource.local.ClientLocalDataSource
import com.example.mystudioapplication.data.dataSource.local.ProductsLocalDataSource
import com.example.mystudioapplication.data.dataSource.remote.ProductRemoteDataSource
import com.example.mystudioapplication.data.dataSource.remote.ProductRemoteDataSourceImpl
import com.example.mystudioapplication.data.repository.ClientRepositoryImpl
import com.example.mystudioapplication.data.repository.ProductRepositoryImpl
import com.example.mystudioapplication.domain.repository.ClientRepository
import com.example.mystudioapplication.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideClientRepository(
        clientLocalDataSource: ClientLocalDataSource
    ): ClientRepository =
        ClientRepositoryImpl(clientLocalDataSource)

    @Provides
    fun provideProductRepository(
        productRemoteDataSource: ProductRemoteDataSource,
        productsLocalDataSource: ProductsLocalDataSource
    ): ProductRepository =
        ProductRepositoryImpl(productRemoteDataSource, productsLocalDataSource)

}