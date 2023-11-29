package com.maciejbandel.guidebook.util // ktlint-disable filename

import java.time.LocalDate
import java.time.format.DateTimeFormatter

val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")


fun LocalDate.formatToString(): String {
    return this.format(dateFormatter)
}

fun String.parseToDate(): LocalDate = LocalDate.parse(this, dateFormatter)