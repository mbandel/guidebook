package com.maciejbandel.guidebook.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DateProvider @Inject constructor() {

    fun getCurrentDate() = LocalDate.now()
}