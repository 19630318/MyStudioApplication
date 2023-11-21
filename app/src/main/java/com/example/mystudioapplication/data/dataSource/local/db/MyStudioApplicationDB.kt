package com.example.mystudioapplication.data.dataSource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mystudioapplication.data.dataSource.local.dao.ClientDao
import com.example.mystudioapplication.data.dataSource.local.dao.ProductDao
import com.example.mystudioapplication.data.dataSource.local.entity.ClientEntity
import com.example.mystudioapplication.data.dataSource.local.entity.ProductEntity

@Database(
    entities = [ClientEntity::class, ProductEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MyStudioApplicationDB: RoomDatabase() {

    abstract fun clientDao(): ClientDao

    abstract fun productDao(): ProductDao

}