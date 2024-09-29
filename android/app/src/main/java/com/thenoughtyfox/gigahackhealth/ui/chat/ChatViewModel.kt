package com.thenoughtyfox.gigahackhealth.ui.chat

import android.app.Application
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.thenoughtyfox.gigahackhealth.net.ChatApi
import com.thenoughtyfox.gigahackhealth.net.ChatDTO
import com.thenoughtyfox.gigahackhealth.net.ChatSendDTO
import com.thenoughtyfox.gigahackhealth.net.ContentItem
import com.thenoughtyfox.gigahackhealth.net.Doctor
import com.thenoughtyfox.gigahackhealth.net.Routine
import com.thenoughtyfox.gigahackhealth.net.helper.toOperationResult
import com.thenoughtyfox.gigahackhealth.net.interceptor.HeaderInterceptor
import com.thenoughtyfox.gigahackhealth.utils.PreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.logging.HttpLoggingInterceptor
import org.openapitools.client.apis.ResourcesApi
import org.openapitools.client.apis.RoutinesApi
import org.openapitools.client.infrastructure.ApiClient
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val preferenceManager: PreferenceManager,
    private val resourcesApi: ResourcesApi,
    private val routinesApi: RoutinesApi,
    private val application: Application
) : ViewModel() {

    val event = Channel<Event>(Channel.UNLIMITED)

    private val _state = MutableStateFlow(State())
    val state = _state.asStateFlow()

    private val _action = MutableSharedFlow<Action>()
    val action: SharedFlow<Action> = _action

    private val apiClient by lazy {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttp = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(HeaderInterceptor())
            .readTimeout(10000, TimeUnit.SECONDS)
            .connectTimeout(10000, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)

        ApiClient(baseUrl = "http://172.31.106.49:8000/", okHttp)
    }

    init {
        handleEvents()
    }

    private fun handleEvents() = viewModelScope.launch {
        event.consumeAsFlow().collect { event ->
            when (event) {
                is Event.GetToken -> {
                    if (preferenceManager.threadId.isEmpty()) {
                        getThreadId()
                    } else {
                        _state.update { it.copy(chatThreadId = preferenceManager.threadId) }
                        getAllMessages()
                    }
                }

                is Event.SendMessage -> sendMessage(event.message)
                is Event.SendUri -> sendUriToServer(event.uri)
            }
        }
    }

    private fun getAllMessages() = viewModelScope.launch {
        val chatApi = apiClient.createService(ChatApi::class.java)
        chatApi.getThreadMessages(state.value.chatThreadId)
            .toOperationResult {
                it
            }.onSuccess { chats ->

                val chatMessages = chats.flatMap { message ->
                    message.value.map { contentItem ->
                        val doctors = fetchDoctorsData(contentItem.doctors)
                        val routines = fetchRoutinesData(contentItem.routines)

                        ChatMessage(
                            id = state.value.chatThreadId,
                            message1 = contentItem.message1,
                            message2 = contentItem.message2,
                            message3 = contentItem.message3,
                            isUser = message.role == "user",
                            doctors = doctors,
                            routines = routines,
                            type = if (doctors.isNotEmpty() || routines.isNotEmpty()) ChatType.SUGGESTIONS else ChatType.TEXT
                        )
                    }
                }

                _state.update { it.copy(chatMessages = chatMessages) }
            }.onError {
                Timber.e(it)
            }
    }

    private fun getThreadId() = viewModelScope.launch {
        val chatApi = apiClient.createService(ChatApi::class.java)
        chatApi.getThreadId().toOperationResult {
            it
        }.onSuccess { token ->
            preferenceManager.threadId = token.replace("\"", "")
            _state.update { it.copy(chatThreadId = token.replace("\"", "")) }
            getAllMessages()
        }.onError {
            Timber.e(it)
        }
    }

    private fun sendMessage(promt: String) = viewModelScope.launch {
        val messages = state.value.chatMessages.toMutableList()
        messages.add(
            0,
            ChatMessage(
                state.value.chatThreadId, promt, isUser = true, type = ChatType.TEXT
            )
        )

        _state.update { it.copy(chatMessages = messages) }
        val chatApi = apiClient.createService(ChatApi::class.java)
        chatApi.sendMessage(promt, state.value.chatThreadId, "Giovanni")
            .toOperationResult { it }
            .onSuccess {
                val message = state.value.chatMessages.toMutableList()
                val content = it.response.first().content.first()
                val type =
                    if (!content.doctors.isNullOrEmpty() || !content.routines.isNullOrEmpty()) ChatType.SUGGESTIONS else ChatType.TEXT

                if (type == ChatType.SUGGESTIONS) {
                    fetchDoctorsData(content)
                } else {
                    message.add(
                        0,
                        ChatMessage(
                            id = it.threadId,
                            message1 = content.message1,
                            message2 = content.message2,
                            message3 = content.message3,
                            doctors = content.doctors ?: listOf(),
                            routines = content.routines ?: listOf(),
                            isUser = false,
                            type = type
                        )
                    )

                    _state.update { uiState -> uiState.copy(chatMessages = message) }
                }
            }.onError {
                Timber.e(it)
            }
    }

    private suspend fun fetchDoctorsData(doctors: List<Doctor>?): List<Doctor> {
        return doctors?.map { doctor ->
            viewModelScope.async {
                val id = doctor.id.toIntOrNull() ?: return@async null
                val response = resourcesApi.employeesGetEmployees(id)
                response.body()?.firstOrNull()?.let { employee ->
                    Doctor(
                        id = employee.id.toString(),
                        name = employee.fullName.toString()
                    )
                }
            }
        }?.awaitAll()?.filterNotNull() ?: listOf()
    }

    private suspend fun fetchRoutinesData(routines: List<Routine>?): List<Routine> {
        return routines?.map { routine ->
            viewModelScope.async {
                val id = routine.id.toIntOrNull() ?: return@async null
                val response = routinesApi.routinesGetRoutine(id)
                response.body()?.let { fetchedRoutine ->
                    Routine(
                        id = fetchedRoutine.code ?: "",
                        name = fetchedRoutine.name.toString()
                    )
                }
            }
        }?.awaitAll()?.filterNotNull() ?: listOf()
    }

    private fun fetchDoctorsData(content: ContentItem) = viewModelScope.launch {
        val doctorsList = fetchDoctorsData(content.doctors)
        val routinesList = fetchRoutinesData(content.routines)
        val message = state.value.chatMessages.toMutableList()
        message.add(
            0,
            ChatMessage(
                id = preferenceManager.threadId,
                message1 = content.message1,
                message2 = content.message2,
                message3 = content.message3,
                doctors = doctorsList,
                routines = routinesList,
                isUser = false,
                type = ChatType.SUGGESTIONS
            )
        )

        _state.update { uiState -> uiState.copy(chatMessages = message) }
    }


    fun getImageNameFromUri(context: Context, uri: Uri): String? {
        val projection = arrayOf(MediaStore.Images.Media.DISPLAY_NAME)
        val cursor: Cursor? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            context.contentResolver.query(uri, projection, null, null, null)
        } else {
            val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
            context.contentResolver.query(uri, filePathColumn, null, null, null)
        }
        cursor?.use {
            if (it.moveToFirst()) {
                val nameIndex = it.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME)
                return it.getString(nameIndex)
            }
        }
        return null
    }

    private fun sendUriToServer(uri: Uri) = viewModelScope.launch(context = Dispatchers.IO) {
        try {
            val promt = getImageNameFromUri(application.applicationContext, uri)
            val url =
                "http://172.31.106.49:8000/api/thread?prompt=$promt&threadId=${state.value.chatThreadId}&nameUser=Giovanni"
            val contentResolver = application.contentResolver
            val inputStream = contentResolver.openInputStream(uri)
            val byteArray = inputStream?.readBytes()

            val requestBody =
                byteArray?.toRequestBody("application/octet-stream".toMediaTypeOrNull())
            val filePart = requestBody?.let {
                MultipartBody.Part.createFormData("file", "filename", it)
            } ?: return@launch

            val multipartBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addPart(filePart)
                .build()

            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .readTimeout(1000000, TimeUnit.SECONDS)
                .connectTimeout(1000000, TimeUnit.SECONDS)
                .writeTimeout(1000000, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build()

            val request = Request.Builder()
                .url(url)
                .post(multipartBody)
                .build()

            val messages = state.value.chatMessages.toMutableList()
            messages.add(
                0,
                ChatMessage(
                    state.value.chatThreadId, promt, isUser = true, type = ChatType.IMAGE, uri = uri
                )
            )

            _state.update { uiState -> uiState.copy(chatMessages = messages) }

            val response = okHttpClient.newCall(request).execute()
            if (response.isSuccessful) {
                response.body?.use { responseBody ->
                    val responseBodyString = responseBody.string()
                    val chatDTO = Gson().fromJson(responseBodyString, ChatSendDTO::class.java)
                    Timber.d("URI sent successfully: $chatDTO")

                    val message = state.value.chatMessages.toMutableList()
                    val content = chatDTO.response.first().content.first()
                    val type =
                        if (!content.doctors.isNullOrEmpty() || !content.routines.isNullOrEmpty()) ChatType.SUGGESTIONS else ChatType.TEXT

                    if (type == ChatType.SUGGESTIONS) {
                        fetchDoctorsData(content)
                    } else {
                        message.add(
                            0,
                            ChatMessage(
                                id = chatDTO.threadId,
                                message1 = content.message1,
                                message2 = content.message2,
                                message3 = content.message3,
                                doctors = content.doctors ?: listOf(),
                                routines = content.routines ?: listOf(),
                                isUser = false,
                                type = type
                            )
                        )

                        _state.update { uiState -> uiState.copy(chatMessages = message) }
                    }
                }

                Timber.d("URI sent successfully")
            } else {
                Timber.e("Failed to send URI: ${response.message}")
            }
        } catch (e: Exception) {
            Timber.e(e, "Error sending URI to server")
        }
    }

    fun parseApiResponse(json: String): ChatSendDTO {
        val gson = Gson()
        val type = object : TypeToken<ChatSendDTO>() {}.type
        return gson.fromJson(json, type)
    }

}

enum class ChatType {
    TEXT,
    IMAGE,
    SUGGESTIONS
}

data class ChatMessage(
    val id: String,
    val message1: String?,
    val message2: String? = "",
    val message3: String? = "",
    val isUser: Boolean,
    val doctors: List<Doctor> = listOf(),
    val routines: List<Routine> = listOf(),
    val uri: Uri? = null,
    val type: ChatType = ChatType.TEXT,
)