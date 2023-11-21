package com.example.mystudioapplication.domain.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName


data class MenuNetwork(

    @SerializedName("menu")
    val items: List<MenuItemNetwork>
):java.io.Serializable{

    fun toJson(): String = Gson().toJson(MenuNetwork(
        items
    ))

    companion object{
        fun fromJson(data: String): MenuNetwork = Gson().fromJson(data, MenuNetwork::class.java)
    }

}
data class MenuItemNetwork(
    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("price")
    val price: Double,

    @SerializedName("category")
    val category: String,

    @SerializedName("image")
    val imageUrl: String
):java.io.Serializable{

    fun toJson(): String = Gson().toJson(MenuItemNetwork(
        id,
        title,
        description,
        price,
        category,
        imageUrl
    ))

    companion object{
        fun fromJson(data: String): MenuItemNetwork = Gson().fromJson(data, MenuItemNetwork::class.java)
    }

}

