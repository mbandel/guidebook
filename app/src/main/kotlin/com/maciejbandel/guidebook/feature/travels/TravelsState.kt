package com.maciejbandel.guidebook.feature.travels

import com.maciejbandel.guidebook.feature.travels.data.PlaceViewData
import com.maciejbandel.guidebook.feature.travels.data.TravelViewData
import com.maciejbandel.guidebook.model.Place

data class TravelsState(
    val isDropDownMenuExpanded: Boolean = false,
    val travels: List<TravelViewData> = emptyList(),
    val places: List<PlaceViewData> = emptyList(),
    val dates: List<String> = emptyList(),
    val selectedTravelId: Long? = null,
    val selectedTravelName: String = ""
)
