package com.example.mystudioapplication.domain.usecase.product

import com.example.mystudioapplication.domain.model.Client
import com.example.mystudioapplication.domain.repository.ClientRepository
import com.example.mystudioapplication.domain.repository.ProductRepository


class ProductFindAllUseCase(private val productRepository: ProductRepository) {

    suspend operator fun invoke() =
        productRepository.findAllProducts()

}