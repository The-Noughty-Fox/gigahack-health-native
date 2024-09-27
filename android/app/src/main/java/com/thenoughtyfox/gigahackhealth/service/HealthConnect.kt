package com.thenoughtyfox.gigahackhealth.service

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.health.connect.client.HealthConnectClient
import androidx.health.connect.client.permission.HealthPermission
import androidx.health.connect.client.records.HeartRateRecord
import androidx.health.connect.client.records.StepsRecord
import androidx.health.connect.client.request.ReadRecordsRequest
import androidx.health.connect.client.time.TimeRangeFilter
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

class HealthConnect(
    private val context: Context,
    private val activity: ComponentActivity
) {

    private val providerPackageName = "com.google.android.apps.healthdata"

    val healthConnectClient by lazy {
        HealthConnectClient.getOrCreate(context)
    }

    val availabilityStatus by lazy {
        HealthConnectClient.getSdkStatus(context, providerPackageName)
    }

    init {
        isAvailableHealthConnect()
    }

    suspend fun readStepsByTimeRange() {
        try {
            val today = ZonedDateTime.now()
            val startOfDay = today.truncatedTo(ChronoUnit.DAYS)
            val timeRangeFilter = TimeRangeFilter.between(
                startOfDay.toLocalDateTime(),
                today.toLocalDateTime()
            )

            val response = healthConnectClient.readRecords(
                ReadRecordsRequest(
                    StepsRecord::class,
                    timeRangeFilter = timeRangeFilter
                )
            )


            val stepsRecordRequest = ReadRecordsRequest(StepsRecord::class, timeRangeFilter)
            val numberOfStepsToday = healthConnectClient.readRecords(stepsRecordRequest)
                .records
                .sumOf { it.count }



            numberOfStepsToday

            for (stepRecord in response.records) {
                // Process each step record
            }
        } catch (e: Exception) {
            e.printStackTrace()
            // Run error handling here.
        }
    }

    private fun isAvailableHealthConnect() {
        if (availabilityStatus == HealthConnectClient.SDK_UNAVAILABLE) {
            return // early return as there is no viable integration
        }

        if (availabilityStatus == HealthConnectClient.SDK_UNAVAILABLE_PROVIDER_UPDATE_REQUIRED) {
            // Optionally redirect to package installer to find a provider, for example:
            val uriString =
                "market://details?id=$providerPackageName&url=healthconnect%3A%2F%2Fonboarding"
            context.startActivity(
                Intent(Intent.ACTION_VIEW).apply {
                    setPackage("com.android.vending")
                    data = Uri.parse(uriString)
                    putExtra("overlay", true)
                    putExtra("callerId", context.packageName)
                }
            )

            return
        }
    }
}

val healthPermissions = setOf(
    HealthPermission.getReadPermission(HeartRateRecord::class),
    HealthPermission.getWritePermission(HeartRateRecord::class),
    HealthPermission.getReadPermission(StepsRecord::class),
    HealthPermission.getWritePermission(StepsRecord::class),
)