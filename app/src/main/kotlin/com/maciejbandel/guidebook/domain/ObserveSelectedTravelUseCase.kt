package com.maciejbandel.guidebook.domain

import com.maciejbandel.guidebook.storage.DataStorage
import com.maciejbandel.guidebook.storage.StoreKeys
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveSelectedTravelUseCase @Inject constructor(
    private val dataStorage: DataStorage
) : () -> Flow<Long?> {
    override fun invoke(): Flow<Long?> {
        return dataStorage.observeTravelId(StoreKeys.TRAVEL)
    }
}
