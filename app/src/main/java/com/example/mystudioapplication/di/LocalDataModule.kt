package com.example.mystudioapplication.di

import com.example.mystudioapplication.data.dataSource.local.ClientLocalDataSource
import com.example.mystudioapplication.data.dataSource.local.ClientLocalDataSourceImpl
import com.example.mystudioapplication.data.dataSource.local.ProductsLocalDataSource
import com.example.mystudioapplication.data.dataSource.local.ProductsLocalDataSourceImpl
import com.example.mystudioapplication.data.dataSource.local.dao.ClientDao
import com.example.mystudioapplication.data.dataSource.local.dao.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    fun provideCategoriesLocalDataSource(clientDao: ClientDao): ClientLocalDataSource =
        ClientLocalDataSourceImpl(clientDao)

    @Provides
    fun provideProductsLocalDataSource(productDao: ProductDao): ProductsLocalDataSource =
        ProductsLocalDataSourceImpl(productDao)

}