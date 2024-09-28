package com.thenoughtyfox.gigahackhealth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.health.connect.client.PermissionController
import androidx.lifecycle.lifecycleScope
import com.thenoughtyfox.gigahackhealth.navigation.RootGraph
import com.thenoughtyfox.gigahackhealth.service.HealthConnect
import com.thenoughtyfox.gigahackhealth.service.healthPermissions
import com.thenoughtyfox.gigahackhealth.ui.theme.GigahackHealthTheme
import com.thenoughtyfox.gigahackhealth.utils.PreferenceManager
import com.thenoughtyfox.gigahackhealth.utils.setStatusBarFontColor
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var preferenceManager: PreferenceManager

    private val requestPermissionActivityContract by lazy {
        PermissionController.createRequestPermissionResultContract()
    }

    val healthConnect by lazy {
        HealthConnect(this, this)
    }

    private val requestPermissions =
        registerForActivityResult(requestPermissionActivityContract) { granted ->
            if (granted.containsAll(healthPermissions)) {
                lifecycleScope.launch {
                    val granted =
                        healthConnect.healthConnectClient.permissionController.getGrantedPermissions()
                    if (granted.containsAll(healthPermissions)) {
                        // Permissions already granted; proceed with inserting or reading data
                        healthConnect.readStepsByTimeRange()
                    } else {
                        Timber.e("Get permission")
                        // Lack of required permissions
                    }

                }
            } else {
                Timber.e("Get permission")
                // Lack of required permissions
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        requestPermissions.launch(healthPermissions)
        setStatusBarFontColor(isDarkMode = false)
        setContent {
            GigahackHealthTheme {
                RootGraph(preferenceManager)
            }
        }
    }
}