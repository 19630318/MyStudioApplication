package com.example.mystudioapplication.di

import android.app.Application
import androidx.room.Room
import com.example.mystudioapplication.data.dataSource.local.dao.ClientDao
import com.example.mystudioapplication.data.dataSource.local.dao.ProductDao
import com.example.mystudioapplication.data.dataSource.local.db.MyStudioApplicationDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): MyStudioApplicationDB =
        Room.databaseBuilder(app, MyStudioApplicationDB::class.java, "my_studio_application_db")
            .fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideClientDao(db: MyStudioApplicationDB): ClientDao = db.clientDao()

    @Provides
    @Singleton
    fun provideProductDao(db: MyStudioApplicationDB): ProductDao = db.productDao()

}