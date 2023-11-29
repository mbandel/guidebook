package com.maciejbandel.guidebook.model

import java.time.LocalDate

data class Place(
    val name: String,
    val date: LocalDate,
    val visited: Boolean = false
)
