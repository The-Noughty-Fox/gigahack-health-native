package com.thenoughtyfox.gigahackhealth.utils

import android.app.Activity
import android.os.Build
import android.view.View
import androidx.core.view.WindowInsetsControllerCompat

fun Activity.setStatusBarFontColor(isDarkMode: Boolean) {
    this.window?.let { window ->
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val controller = WindowInsetsControllerCompat(window, window.decorView)
            controller.isAppearanceLightStatusBars = !isDarkMode // Set to false for dark font
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = if (isDarkMode) {
                window.decorView.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            } else {
                window.decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }
    }
}