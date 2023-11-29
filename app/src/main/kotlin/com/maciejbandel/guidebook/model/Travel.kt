package com.maciejbandel.guidebook.model

import java.time.LocalDate

data class Travel(
    val id: Long,
    val name: String,
    val places: List<Place>,
    val startDate: LocalDate,
    val endDate: LocalDate
)
