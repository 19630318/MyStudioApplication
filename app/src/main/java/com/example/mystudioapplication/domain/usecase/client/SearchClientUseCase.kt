package com.example.mystudioapplication.domain.usecase.client

import com.example.mystudioapplication.domain.model.Client
import com.example.mystudioapplication.domain.repository.ClientRepository

class SearchClientUseCase(private val clientRepository: ClientRepository) {

    suspend operator fun invoke(email: String, password: String) =
        clientRepository.searchClient(email, password)

}