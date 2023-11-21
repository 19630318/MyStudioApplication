package com.example.mystudioapplication.data.dataSource.remote.service

import com.example.mystudioapplication.domain.model.MenuNetwork
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {

    @GET("Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json")
    suspend fun findAllProducts(
    ): Response<MenuNetwork>

}