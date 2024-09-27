package com.thenoughtyfox.gigahackhealth.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalColors = staticCompositionLocalOf { HealthColor() }

object GigahackHealthTheme {
    val colors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current
}

@Composable
fun GigahackHealthTheme(
    colors: HealthColor = GigahackHealthTheme.colors,
    content: @Composable () -> Unit
) = CompositionLocalProvider(LocalColors provides colors) {
    MaterialTheme {
        content()
    }
}