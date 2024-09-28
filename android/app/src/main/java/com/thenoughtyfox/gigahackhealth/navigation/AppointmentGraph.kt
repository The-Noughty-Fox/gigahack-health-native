package com.thenoughtyfox.gigahackhealth.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thenoughtyfox.gigahackhealth.ui.appointment.AppointmentListPage
import com.thenoughtyfox.gigahackhealth.ui.appointment.AppointmentPage
import com.thenoughtyfox.gigahackhealth.ui.auth.AuthPage
import com.thenoughtyfox.gigahackhealth.ui.onboarding.OnBoardingController
import kotlinx.serialization.Serializable


interface AppointmentNavDestinations {
    @Serializable
    data object Main : AppointmentNavDestinations

    @Serializable
    data object List : AppointmentNavDestinations

    @Serializable
    data object Program : AppointmentNavDestinations

    @Serializable
    data object Info : AppointmentNavDestinations
}

@Composable
fun AppointmentGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppointmentNavDestinations.Main,
        modifier = Modifier.fillMaxSize()
    ) {
        composable<AppointmentNavDestinations.Main> {
            AppointmentPage(onPageClicked = {
                navController.navigate(AppointmentNavDestinations.List)
            })
        }
        composable<AppointmentNavDestinations.List> { AppointmentListPage() }
        composable<AppointmentNavDestinations.Program> { AppointmentPage() }
        composable<AppointmentNavDestinations.Info> { AppointmentPage() }
    }
}

val LocalAppointmentNavigator =
    staticCompositionLocalOf<NavHostController> { error("Error! navController wasn't initialized!") }
