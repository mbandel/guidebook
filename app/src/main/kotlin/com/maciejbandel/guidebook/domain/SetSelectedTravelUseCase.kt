package com.maciejbandel.guidebook.domain

import com.maciejbandel.guidebook.storage.DataStorage
import com.maciejbandel.guidebook.storage.StoreKeys
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SetSelectedTravelUseCase @Inject constructor(
    private val dataStorage: DataStorage
) : suspend (Long) -> Unit {
    override suspend fun invoke(id: Long) {
        dataStorage.save(key = StoreKeys.TRAVEL, value = id)
    }
}