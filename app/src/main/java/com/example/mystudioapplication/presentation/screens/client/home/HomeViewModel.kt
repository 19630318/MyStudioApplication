package com.example.mystudioapplication.presentation.screens.client.home

import android.content.SharedPreferences
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mystudioapplication.domain.model.MenuNetwork
import com.example.mystudioapplication.domain.usecase.product.ProductUseCase
import com.example.mystudioapplication.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val productUseCase: ProductUseCase
): ViewModel() {

    var productsRespose by mutableStateOf<Resource<MenuNetwork>?>(null)
        private set

    init {
        getProducts()
    }

    fun borrardatos(){
        sharedPreferences.edit().clear().apply()
    }

    fun getProducts() = viewModelScope.launch {
        productsRespose = Resource.Loading
        productUseCase.productFindAllUseCase().collect(){
            Log.d("HomeViewModel", "data: ${it}")
            productsRespose = it
        }
    }

}