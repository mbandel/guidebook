package com.maciejbandel.guidebook.feature.travels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maciejbandel.guidebook.domain.GetTravelsUseCase
import com.maciejbandel.guidebook.domain.ObserveSelectedTravelUseCase
import com.maciejbandel.guidebook.domain.SetSelectedTravelUseCase
import com.maciejbandel.guidebook.feature.travels.TravelsState
import com.maciejbandel.guidebook.feature.travels.data.PlaceViewData
import com.maciejbandel.guidebook.feature.travels.data.toViewData
import com.maciejbandel.guidebook.util.Launched
import com.maciejbandel.guidebook.util.stateInMerge
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TravelsViewModel @Inject constructor(
    private val observeSelectedTravelUseCase: ObserveSelectedTravelUseCase,
    private val getTravelsUseCase: GetTravelsUseCase,
    private val setSelectedTravelUseCase: SetSelectedTravelUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(TravelsState())
        .stateInMerge(
            scope = viewModelScope,
            launched = Launched.WhileSubscribed(5_000L),
            {
                observeSelectedTravelUseCase().onEachToState { selectedTravelId, state ->
                    state.copy(
                        selectedTravelId = selectedTravelId,
                        selectedTravelName = state.travels.find { travelViewData ->
                            travelViewData.id == selectedTravelId
                        }?.name ?: "",
                        places = state.travels.find { travelViewData ->
                            travelViewData.id == selectedTravelId
                        }?.places?.sortedBy { it.date } ?: emptyList()
                    )
                }
            },
            {
                getTravelsUseCase().onEachToState { travels, state ->
                    state.copy(travels = travels.map { it.toViewData() })
                }
            }
        )

    val state get() = _state

    fun onTravelsDropdownOpened() {
        _state.update { it.copy(isDropDownMenuExpanded = true) }
    }

    fun onTravelsDropdownClosed() {
        _state.update { it.copy(isDropDownMenuExpanded = false) }
    }

    fun onTravelSelected(selectedTravelId: Long) {
        onTravelsDropdownClosed()
        viewModelScope.launch {
            setSelectedTravelUseCase(id = selectedTravelId)
        }
    }

    fun onPlaceCheckboxClicked(place: PlaceViewData) {
        _state.update { state ->
            state.copy(places = state.places.map {
                if (it == place) place.copy(visited = !place.visited)
                else it
            })
        }
    }
}
