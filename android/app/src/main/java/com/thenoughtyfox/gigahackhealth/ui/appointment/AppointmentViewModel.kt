package com.thenoughtyfox.gigahackhealth.ui.appointment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thenoughtyfox.gigahackhealth.net.helper.toOperationResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.openapitools.client.apis.DictionariesApi
import org.openapitools.client.apis.PricingApi
import org.openapitools.client.apis.ResourcesApi
import org.openapitools.client.apis.RoutinesApi
import org.openapitools.client.models.EmployeeApiInfo
import org.openapitools.client.models.EntityApiInfo
import org.openapitools.client.models.RoutineApiSearchResult
import org.openapitools.client.models.UnitApiInfo
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AppointmentViewModel @Inject constructor(
    private val routines: RoutinesApi,
    private val resourcesApi: ResourcesApi,
    private val dictionariesApi: DictionariesApi,
    private val pricingApi: PricingApi
) : ViewModel() {

    val event = Channel<Event>(Channel.UNLIMITED)

    private val _state = MutableStateFlow(State())
    val state = _state.asStateFlow()

    private val _action = MutableSharedFlow<Action>()
    val action: SharedFlow<Action> = _action

    init {
        fetch()
    }

    private fun fetch() = viewModelScope.launch(Dispatchers.IO) {
        val routinesDeferred = async { routines.routinesSearchRoutines() }
        val unitsDeferred = async { resourcesApi.unitsGet() }
        val specialitiesDeferred = async { dictionariesApi.specialitiesGet() }
        val employeesDeferred = async { resourcesApi.employeesGetEmployees() }

        // Await all results
        val results =
            awaitAll(routinesDeferred, unitsDeferred, specialitiesDeferred, employeesDeferred)

        // Cast results to appropriate types
        val routinesResult = results[0] as Response<List<RoutineApiSearchResult>>
        val unitsResult = results[1] as Response<List<UnitApiInfo>>
        val specialitiesResult = results[2] as Response<List<EntityApiInfo>>
        val employeesResult = results[3] as Response<List<EmployeeApiInfo>>

        // Read the response bodies
        val routinesBody = routinesResult.body()
        val unitsBody = unitsResult.body()
        val specialitiesBody = specialitiesResult.body()
        val employeesBody = employeesResult.body()

        // Update the state with the fetched data
        _state.update { currentState ->
            currentState.copy(
                routines = routinesBody ?: emptyList(),
                units = unitsBody ?: emptyList(),
                specialities = specialitiesBody ?: emptyList(),
                employees = employeesBody ?: emptyList()
            )
        }
    }

    fun getAbilities(executorId: Int, abi: (List<RoutineApiSearchResult>) -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            resourcesApi.executorsGetAbilities(executorId).toOperationResult { it }
                .onSuccess {
                    val routineID = it.mapNotNull { it.routineId }
                    val search = state.value.routines.filter { it.id in routineID }
                    _state.update { it.copy(search = search) }
                }
                .onError { }
        }
}