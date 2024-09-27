package com.thenoughtyfox.gigahackhealth.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.thenoughtyfox.gigahackhealth.ui.view.BottomNavBar
import com.thenoughtyfox.gigahackhealth.ui.view.BottomNavData
import com.thenoughtyfox.gigahackhealth.utils.navigateSingleTop
import kotlinx.serialization.Serializable

interface MainNavDestinations {
    @Serializable
    data object Appointment : MainNavDestinations

    @Serializable
    data object Home : MainNavDestinations

    @Serializable
    data object Chat : MainNavDestinations

    @Serializable
    data object Profile : MainNavDestinations
}


@Composable
fun MainGraph() {
    val navController = rememberNavController()
    CompositionLocalProvider(LocalMainNavigator provides navController) {
        var currentNavItem by remember { mutableStateOf(BottomNavData.Home) }
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        LaunchedEffect(navBackStackEntry) {
            when (navBackStackEntry?.destination?.route?.substringAfterLast(".")) {
                MainNavDestinations.Appointment.toString() -> {
                    currentNavItem = BottomNavData.Appointment
                }

                MainNavDestinations.Home.toString() -> {
                    currentNavItem = BottomNavData.Home
                }

                MainNavDestinations.Chat.toString() -> {
                    currentNavItem = BottomNavData.Chat
                }

                MainNavDestinations.Profile.toString() -> {
                    currentNavItem = BottomNavData.Profile
                }
            }
        }

        Scaffold(
            topBar = {},
            bottomBar = {
                BottomNavBar(
                    selected = currentNavItem,
                    onSelectTab = { navTabs ->
                        if (navTabs == currentNavItem) return@BottomNavBar
                        when (navTabs.name) {
                            BottomNavData.Appointment.name -> {
                                navController.navigateSingleTop(MainNavDestinations.Appointment)
                            }

                            BottomNavData.Home.name -> {
                                navController.navigateSingleTop(MainNavDestinations.Home)
                            }

                            BottomNavData.Chat.name -> {
                                navController.navigateSingleTop(MainNavDestinations.Chat)
                            }

                            BottomNavData.Profile.name -> {
                                navController.navigateSingleTop(MainNavDestinations.Profile)
                            }
                        }
                    },
                    modifier = Modifier
                        .navigationBarsPadding()
                        .fillMaxWidth()
                )
            },
            content = { padding ->
                NavHost(
                    navController = navController,
                    startDestination = MainNavDestinations.Home,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                ) {
                    composable<MainNavDestinations.Appointment> { }
                    composable<MainNavDestinations.Home> { }
                    composable<MainNavDestinations.Chat> { }
                    composable<MainNavDestinations.Profile> { }
                }
            }
        )
    }
}

val LocalMainNavigator =
    staticCompositionLocalOf<NavHostController> { error("Error! navController wasn't initialized!") }