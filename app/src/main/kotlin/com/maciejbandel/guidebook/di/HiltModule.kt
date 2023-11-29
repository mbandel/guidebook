package com.maciejbandel.guidebook.di

import android.app.Application
import android.content.Context
import android.provider.SyncStateContract
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Database
import androidx.room.Room
import com.maciejbandel.guidebook.database.GuidebookDatabase
import com.maciejbandel.guidebook.database.dao.TravelsDao
import com.maciejbandel.guidebook.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProvidesModule {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
        name = "data_store",
    )

    @Provides
    @Singleton
    fun provideDataStore(context: Application): DataStore<Preferences> {
        return context.dataStore
    }

    @Provides
    @Singleton
    fun provideDatabase(context: Application): GuidebookDatabase {
        return Room.databaseBuilder(
            context,
            GuidebookDatabase::class.java,
            DATABASE_NAME,
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideTravelsDao(database: GuidebookDatabase): TravelsDao {
        return database.getTravelsDao()
    }
}
