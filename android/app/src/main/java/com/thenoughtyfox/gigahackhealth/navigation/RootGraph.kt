package com.thenoughtyfox.gigahackhealth.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thenoughtyfox.gigahackhealth.utils.PreferenceManager
import kotlinx.serialization.Serializable

interface RootNavDestinations {
    @Serializable
    data object OnBoarding : RootNavDestinations

    @Serializable
    data object Auth : RootNavDestinations

    @Serializable
    data object Main : RootNavDestinations
}

@Composable
fun RootGraph(preferenceManager: PreferenceManager) {
    val navController = rememberNavController()
    val startDestination = if (preferenceManager.isPassOnboarding) {
        RootNavDestinations.Auth
    } else {
        RootNavDestinations.OnBoarding
    }

    CompositionLocalProvider(LocalRootNavigator provides navController) {
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier.fillMaxSize()
        ) {
            composable<RootNavDestinations.OnBoarding> {
//                OnBoardingController(onFinishPress = {
//                    preferenceManager.isPassOnboarding = true
//                    navController.navigate(Web) {
//                        popUpTo(OnBoarding) {
//                            inclusive = true
//                        }
//                    }
//                })
            }

            composable<RootNavDestinations.Auth> { }
            composable<RootNavDestinations.Main> { MainGraph()}
        }
    }
}


val LocalRootNavigator =
    staticCompositionLocalOf<NavHostController> { error("Error! navController wasn't initialized!") }
