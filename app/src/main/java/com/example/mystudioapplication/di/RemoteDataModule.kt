package com.example.mystudioapplication.di

import com.example.mystudioapplication.data.dataSource.remote.ProductRemoteDataSource
import com.example.mystudioapplication.data.dataSource.remote.ProductRemoteDataSourceImpl
import com.example.mystudioapplication.data.dataSource.remote.service.ProductService
import com.example.mystudioapplication.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Provides
    fun provideProductRemoteSourece(productService: ProductService): ProductRemoteDataSource =
        ProductRemoteDataSourceImpl(productService)

}