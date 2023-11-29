package com.maciejbandel.guidebook.feature.travels.ui

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.maciejbandel.guidebook.feature.travels.data.TravelViewData
import org.w3c.dom.Text

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu(
    travelName: String,
    isMenuExpanded: Boolean,
    onDropdownOpened: () -> Unit,
    onDropdownClosed: () -> Unit,
    travels: List<TravelViewData>,
    onTravelSelected: (Long) -> Unit
) {
    Keyboard.Row {
        ExposedDropdownMenuBox(
            expanded = isMenuExpanded,
            onExpandedChange = { expanded ->
                if (expanded) onDropdownOpened()
                else onDropdownClosed()
            }
        ) {
            TextField(
                value = travelName,
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor(),
                readOnly = true
            )
            ExposedDropdownMenu(
                expanded = isMenuExpanded,
                onDismissRequest = onDropdownClosed
            ) {
                travels.forEach { travelViewData ->
                    DropdownMenuItem(
                        text = { Text(travelViewData.name) },
                        onClick = { onTravelSelected(travelViewData.id) }
                    )
                }
            }
        }
    }
}