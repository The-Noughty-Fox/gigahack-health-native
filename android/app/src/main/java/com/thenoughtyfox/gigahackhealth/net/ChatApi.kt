package com.thenoughtyfox.gigahackhealth.net

import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ChatApi {

    @GET("api/get-thread-id")
    suspend fun getThreadId(): Response<String>

    @POST("api/thread")
    suspend fun sendMessage(
        @Query("prompt") prompt: String,
        @Query("threadId") threadId: String,
        @Query("nameUser") nameUser: String
    ): Response<ChatSendDTO>

    @GET("api/get-thread-messages")
    suspend fun getThreadMessages(
        @Query("threadId") threadId: String
    ): Response<List<ChatDTO>>
}

data class ChatSendDTO(
    @SerializedName("threadId")
    val threadId: String,
    @SerializedName("response")
    val response: List<ResponseItem>
)

data class ResponseItem(
    @SerializedName("role")
    val role: String,
    @SerializedName("content")
    val content: List<ContentItem>
)

data class ContentItem(
    @SerializedName("Message1")
    val message1: String?,
    @SerializedName("Doctors")
    val doctors: List<Doctor>?,
    @SerializedName("Message2")
    val message2: String?,
    @SerializedName("Routines")
    val routines: List<Routine>?,
    @SerializedName("Message3")
    val message3: String?
)

data class Doctor(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)

data class Routine(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)

data class ChatDTO(
    @SerializedName("role")
    val role: String,
    @SerializedName("value")
    val value: List<ContentItem>
)