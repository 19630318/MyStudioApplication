package com.example.mystudioapplication.data.mapper

import com.example.mystudioapplication.data.dataSource.local.entity.ProductEntity
import com.example.mystudioapplication.domain.model.MenuItemNetwork
import com.example.mystudioapplication.domain.model.MenuNetwork

fun ProductEntity.toMenuItemNetwork(): MenuItemNetwork {
    return MenuItemNetwork(
        id = this.id,
        title = this.title,
        description = this.description,
        price = this.price,
        category = this.category,
        imageUrl = this.imageUrl
    )
}

fun MenuItemNetwork.toProductEntity(): ProductEntity {
    return ProductEntity(
        id = this.id,
        title = this.title,
        description = this.description,
        price = this.price,
        category = this.category,
        imageUrl = this.imageUrl
    )
}

fun MenuNetwork.toProductEntityList(): List<ProductEntity> {
    return this.items.map {
        ProductEntity(
            id = it.id,
            title = it.title,
            description = it.description,
            price = it.price,
            category = it.category,
            imageUrl = it.imageUrl
        )
    }
}

fun MenuNetwork.toProductEntity(): ProductEntity? {
    return this.items.firstOrNull()?.let {
        ProductEntity(
            id = it.id,
            title = it.title,
            description = it.description,
            price = it.price,
            category = it.category,
            imageUrl = it.imageUrl
        )
    }
}

// Función de extensión para convertir List<MenuItemNetwork> a MenuNetwork
fun List<MenuItemNetwork>.toMenuNetwork(): MenuNetwork {
    return MenuNetwork(items = this)
}

fun List<MenuItemNetwork>.toProductEntityList(): List<ProductEntity> {
    return this.map { it.toProductEntity() }
}
