package com.maciejbandel.guidebook.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.maciejbandel.guidebook.model.Travel
import com.maciejbandel.guidebook.util.Constants.TRAVEL_TABLE_NAME
import com.maciejbandel.guidebook.util.parseToDate

@Entity(tableName = TRAVEL_TABLE_NAME)
data class TravelEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val startDate: String,
    val endDate: String,
    val places: List<PlaceDto>
)

fun TravelEntity.toDomain(): Travel {
    return Travel(
        id = this.id,
        name = this.name,
        startDate = this.startDate.parseToDate(),
        endDate = this.endDate.parseToDate(),
        places = this.places.map { it.toDomain() }
    )
}
