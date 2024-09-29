package com.thenoughtyfox.gigahackhealth.ui.chat

import android.net.Uri

data class State(
    val chatThreadId: String = "",
    val chatMessages: List<ChatMessage> = listOf()
)

sealed class Event {
    data object GetToken : Event()
    data class SendMessage(val message: String) : Event()
    data class SendUri(val uri: Uri) : Event()
}

sealed class Action {

}