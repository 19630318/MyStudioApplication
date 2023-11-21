package com.example.mystudioapplication.domain.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class Client(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
    ):java.io.Serializable{

    fun toJson(): String = Gson().toJson(Client(
        id,
        name,
        lastName,
        email,
        password
    ))

    companion object{
        fun fromJson(data: String): Client = Gson().fromJson(data, Client::class.java)
    }

}
