package com.maciejbandel.guidebook.ui.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.maciejbandel.guidebook.ui.greeting.greetingGraph
import com.maciejbandel.guidebook.ui.greeting.greetingRoute

@Composable
fun GuidebookNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = greetingRoute,
    ) {
        greetingGraph()
    }
}

