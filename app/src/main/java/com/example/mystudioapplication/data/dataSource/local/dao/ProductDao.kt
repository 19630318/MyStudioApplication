package com.example.mystudioapplication.data.dataSource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mystudioapplication.data.dataSource.local.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(menuItems: ProductEntity)

    @Query("SELECT * FROM products")
    fun getAll(): Flow<List<ProductEntity>>


}