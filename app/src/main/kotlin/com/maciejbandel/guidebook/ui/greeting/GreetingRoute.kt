package com.maciejbandel.guidebook.ui.greeting

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maciejbandel.guidebook.feature.travels.ui.TravelsScreen

const val greetingRoute: String = "greeting_route"

fun NavGraphBuilder.greetingGraph() {
    composable(route = greetingRoute) {
        TravelsScreen()
    }
}
