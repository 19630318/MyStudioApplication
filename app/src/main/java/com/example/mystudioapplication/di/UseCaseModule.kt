package com.example.mystudioapplication.di

import com.example.mystudioapplication.domain.repository.ClientRepository
import com.example.mystudioapplication.domain.repository.ProductRepository
import com.example.mystudioapplication.domain.usecase.client.ClientUseCase
import com.example.mystudioapplication.domain.usecase.client.CreateClientUseCase
import com.example.mystudioapplication.domain.usecase.client.SearchClientUseCase
import com.example.mystudioapplication.domain.usecase.product.ProductFindAllUseCase
import com.example.mystudioapplication.domain.usecase.product.ProductUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideClientUseCase(clientRepository: ClientRepository) = ClientUseCase(
        createClientUseCase = CreateClientUseCase(clientRepository),
        searchClientUseCase = SearchClientUseCase(clientRepository)
    )

    @Provides
    fun provideProductUseCase(productRepository: ProductRepository) = ProductUseCase(
        productFindAllUseCase = ProductFindAllUseCase(productRepository)
    )

}
