package com.maciejbandel.guidebook.domain

import com.maciejbandel.guidebook.domain.repository.TravelRepository
import com.maciejbandel.guidebook.model.Travel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTravelsUseCase @Inject constructor(
    private val travelRepository: TravelRepository
) : () -> Flow<List<Travel>> {
    override fun invoke(): Flow<List<Travel>> {
        return travelRepository.observeTravels()
    }
}