package com.maciejbandel.guidebook.feature.travels.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.maciejbandel.guidebook.feature.travels.TravelsViewModel
import com.maciejbandel.guidebook.feature.travels.data.PlaceViewData

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun TravelsScreen(
    viewModel: TravelsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier.padding(24.dp),
    ) {
        Spacer(modifier = Modifier.padding(top = 24.dp))
        DropDownMenu(
            travelName = state.selectedTravelName,
            isMenuExpanded = state.isDropDownMenuExpanded,
            onDropdownOpened = viewModel::onTravelsDropdownOpened,
            onDropdownClosed = viewModel::onTravelsDropdownClosed,
            travels = state.travels,
            onTravelSelected = viewModel::onTravelSelected
        )

        Spacer(modifier = Modifier.height(32.dp))

        PlacesList(
            places = state.places,
            onCheckBoxClicked = viewModel::onPlaceCheckboxClicked
        )
    }
}

@Composable
private fun PlacesList(
    places: List<PlaceViewData>,
    onCheckBoxClicked: (PlaceViewData) -> Unit
) {
    LazyColumn {
        items(places) { place ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp),
//                modifier = Modifier.border(shape = Shape.)
            ) {
                Text(text = place.date)
                Text(text = place.name)
                Checkbox(
                    checked = place.visited,
                    onCheckedChange = { onCheckBoxClicked(place) }
                )
            }
        }
    }
}