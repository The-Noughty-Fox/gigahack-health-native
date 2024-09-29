package com.thenoughtyfox.gigahackhealth.ui.profile

import com.thenoughtyfox.gigahackhealth.ui.chat.ChatMessage
import org.openapitools.client.models.PersonApiInfo

data class State(
    val loading: Boolean = false,
    val person: PersonApiInfo = PersonApiInfo()
)

sealed class Event {
}

sealed class Action {

}