package com.thenoughtyfox.gigahackhealth.utils

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

fun <T> NavController.navigateSingleTop(route: T) where T : Any {
    navigate(route) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }

        launchSingleTop = true
        restoreState = true
    }
}
