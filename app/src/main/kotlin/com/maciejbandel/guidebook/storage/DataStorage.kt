package com.maciejbandel.guidebook.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataStorage @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    suspend fun save(key: String, value: Long) {
        dataStore.edit { dataStore ->
            dataStore[longPreferencesKey(key)] = value
        }
    }

    fun observeTravelId(key: String): Flow<Long?> =
        dataStore.data.map { dataStore ->
            dataStore[longPreferencesKey(key)]
        }
}
