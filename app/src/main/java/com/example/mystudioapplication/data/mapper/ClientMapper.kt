package com.example.mystudioapplication.data.mapper

import com.example.mystudioapplication.data.dataSource.local.entity.ClientEntity
import com.example.mystudioapplication.domain.model.Client

fun ClientEntity.toClient(): Client{
    return Client(
        id = id,
        name = name,
        lastName = lastName,
        email = email,
        password = password
    )
}

//Aqui estamos haciendo lo mismo pero convertimos a un objeto de category a una categoryEntity
fun Client.toClientEntity(): ClientEntity{
    return ClientEntity(
        id = id?:0,
        name = name,
        lastName = lastName,
        email = email,
        password = password
    )
}