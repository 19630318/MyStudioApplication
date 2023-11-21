package com.example.mystudioapplication.data.dataSource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mystudioapplication.data.dataSource.local.entity.ClientEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ClientDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(productEntity: ClientEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(products: List<ClientEntity>)

    @Query("SELECT * FROM clients")
    fun findAll(): Flow<List<ClientEntity>>

    @Query("SELECT * FROM clients WHERE email = :email AND password = :password")
    fun searchClient(email: String, password: String): ClientEntity

    @Query("DELETE FROM clients WHERE id = :id ")
    suspend fun delete(id: String)

}