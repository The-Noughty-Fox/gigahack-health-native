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
import com.thenoughtyfox.gigahackhealth.ui.appointment.AppointmentCalendarPage
import com.thenoughtyfox.gigahackhealth.ui.appointment.AppointmentInfoPage
import com.thenoughtyfox.gigahackhealth.ui.appointment.AppointmentPage
import com.thenoughtyfox.gigahackhealth.ui.appointment.AppointmentProgramPage
import kotlinx.serialization.Serializable


interface AppointmentNavDestinations {
    @Serializable
    data object Main : AppointmentNavDestinations

    @Serializable
    data object Analysis : AppointmentNavDestinations

    @Serializable
    data object Consult : AppointmentNavDestinations

    @Serializable
    data object Calendar : AppointmentNavDestinations

    @Serializable
    data object Program : AppointmentNavDestinations
}

@Composable
fun AppointmentGraph() {
    val navController = rememberNavController()
    CompositionLocalProvider(LocalAppointmentNavigator provides navController) {
        NavHost(
            navController = navController,
            startDestination = AppointmentNavDestinations.Main,
            modifier = Modifier.fillMaxSize()
        ) {
            composable<AppointmentNavDestinations.Main> {
                AppointmentPage(onPageClicked = {
                    when (it) {
                        AppointmentPage.CONSULT -> navController.navigate(AppointmentNavDestinations.Consult)
                        AppointmentPage.ANALISE, AppointmentPage.INVESTIGATE -> {
                            navController.navigate(AppointmentNavDestinations.Analysis)
                        }
                    }
                })
            }

            composable<AppointmentNavDestinations.Analysis> {
                AppointmentInfoPage(onClickItem = {
                    navController.navigate(AppointmentNavDestinations.Calendar)
                })
            }
            composable<AppointmentNavDestinations.Consult> {
                AppointmentInfoPage(isConsult = true, onClickItem = {
                    navController.navigate(AppointmentNavDestinations.Calendar)
                })
            }

            composable<AppointmentNavDestinations.Calendar> {
                AppointmentCalendarPage(onConfirm = {
                    navController.navigate(AppointmentNavDestinations.Program)
                })
            }

            composable<AppointmentNavDestinations.Program> {
                AppointmentProgramPage(onBackPressed = {
                    navController.popBackStack()
                })
            }
        }
    }
}

val LocalAppointmentNavigator =
    staticCompositionLocalOf<NavHostController> { error("Error! navController wasn't initialized!") }
