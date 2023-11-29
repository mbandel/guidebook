package com.maciejbandel.guidebook.database.model

import com.maciejbandel.guidebook.model.Place
import com.maciejbandel.guidebook.util.parseToDate

data class PlaceDto(
    val name: String,
    val date: String,
    val visited: Boolean
)

fun PlaceDto.toDomain(): Place =
    Place(
        name = this.name,
        date = this.date.parseToDate(),
        visited = this.visited
    )
