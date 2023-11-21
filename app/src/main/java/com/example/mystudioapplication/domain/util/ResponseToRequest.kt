package com.example.mystudioapplication.domain.util

import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

object ResponseToRequest {

    fun <T> send(result: Response<T>): Resource<T>{
        return try {
            if (result.isSuccessful){ //respuesta 201
                Resource.Success(result.body()!!)
            }else{
                //val errorResponse: ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
                Resource.Failure("Error desconocido")
            }
        }catch (e: HttpException){
            e.printStackTrace()
            Resource.Failure(e.message?: "Error desconocido en la petición")
        }
        catch (e: IOException){
            e.printStackTrace()
            Resource.Failure("Verifica tu coneccion a internet")
        }
        catch (e: Exception){
            e.printStackTrace()
            Resource.Failure(e.message?: "Error desconocido")
        }
    }

}