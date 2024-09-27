package com.thenoughtyfox.gigahackhealth.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.thenoughtyfox.gigahackhealth.R

class HealthColor {
    val primary: Color
        @Composable
        @ReadOnlyComposable
        get() = colorResource(R.color.picton_blue_100)

    val selected: Color
        @Composable
        @ReadOnlyComposable
        get() = colorResource(R.color.picton_blue_500)

    val backgroundWhite: Color
        get() = Color.White
}