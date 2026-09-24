package com.example.modoguardian.ui.screens

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import com.example.modoguardian.ui.utils.obtainWindowSizeClass

@Composable
fun HomeScreen2() {
    val windowSizeClass = obtainWindowSizeClass()
    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> HomeScreenCompacta()
    }
}