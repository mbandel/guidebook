package com.maciejbandel.guidebook.ui.greeting

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.maciejbandel.guidebook.ui.common.AppScreen
import com.maciejbandel.guidebook.ui.common.theme.GuidebookTheme

@Composable
fun GreetingScreen() {
    AppScreen {
        Greeting("Android")
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GuidebookTheme { GreetingScreen() }
}
