package com.maciejbandel.guidebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.maciejbandel.guidebook.ui.common.GuidebookNavHost
import com.maciejbandel.guidebook.ui.common.theme.GuidebookTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent { GuidebookTheme { GuidebookNavHost() } }
    }
}
