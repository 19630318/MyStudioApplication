package com.example.mystudioapplication.domain.usecase.client

import com.example.mystudioapplication.domain.model.Client
import com.example.mystudioapplication.domain.repository.ClientRepository

class CreateClientUseCase(private val clientRepository: ClientRepository) {

    suspend operator fun invoke(client: Client) =
        clientRepository.create(client)

}