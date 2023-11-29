package com.maciejbandel.guidebook.domain.repository

import com.maciejbandel.guidebook.database.dao.TravelsDao
import com.maciejbandel.guidebook.database.model.toDomain
import com.maciejbandel.guidebook.model.Travel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TravelRepository @Inject constructor(
    private val travelsDao: TravelsDao
) {
    fun observeTravels(): Flow<List<Travel>> {
        return travelsDao.observeTravels().map { travelsList ->
            travelsList.map { travelEntity ->
                travelEntity.toDomain()
            }
        }
    }
}