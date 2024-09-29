package com.thenoughtyfox.gigahackhealth.ui.appointment

import org.openapitools.client.models.EmployeeApiInfo
import org.openapitools.client.models.EntityApiInfo
import org.openapitools.client.models.RoutineApiSearchResult
import org.openapitools.client.models.UnitApiInfo

data class State(
    val routines: List<RoutineApiSearchResult> = listOf(),
    val units: List<UnitApiInfo> = listOf(),
    val specialities: List<EntityApiInfo> = listOf(),
    val employees: List<EmployeeApiInfo> = listOf(),
    val search: List<RoutineApiSearchResult> = emptyList(),
)

sealed class Event {
}

sealed class Action {

}