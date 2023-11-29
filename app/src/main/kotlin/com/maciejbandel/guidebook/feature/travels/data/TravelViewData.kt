package com.maciejbandel.guidebook.feature.travels.data

import com.maciejbandel.guidebook.model.Place
import com.maciejbandel.guidebook.model.Travel
import com.maciejbandel.guidebook.util.formatToString

data class TravelViewData(
    val id: Long,
    val name: String,
    val places: List<PlaceViewData> = emptyList(),
    val startDate: String,
    val endDate: String
)

fun Travel.toViewData(): TravelViewData =
    TravelViewData(
        id = this.id,
        name = this.name,
        places = places.map {
            PlaceViewData(
                name = it.name,
                date = it.date.formatToString(),
                visited = it.visited
            )
        },
        startDate = startDate.formatToString(),
        endDate = endDate.formatToString()
    )
