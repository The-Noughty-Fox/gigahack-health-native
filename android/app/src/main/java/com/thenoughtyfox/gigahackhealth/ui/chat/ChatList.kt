package com.thenoughtyfox.gigahackhealth.ui.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.thenoughtyfox.gigahackhealth.R
import com.thenoughtyfox.gigahackhealth.net.Doctor
import com.thenoughtyfox.gigahackhealth.net.Routine

@Composable
fun ChatList(messages: List<ChatMessage>, listState: LazyListState) {
    LazyColumn(
        state = listState,
        modifier = Modifier.background(color = colorResource(id = R.color.gray_100)),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        reverseLayout = true
    ) {
        items(messages) { message ->
            ChatListItem(message)
        }
    }
}

@Composable
fun ChatListItem(message: ChatMessage) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = if (message.isUser) Arrangement.End else Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(if (message.isUser) colorResource(R.color.picton_blue_700) else Color.White)
                .padding(8.dp)
        ) {

            when (message.type) {
                ChatType.TEXT -> TextMessageItem(message)
                ChatType.IMAGE -> ImageMessageItem(message)
                ChatType.SUGGESTIONS -> SuggestionMessageItem(message)
            }
        }
    }
}

@Composable
fun TextMessageItem(message: ChatMessage) {
    Text(
        text = message.message1 ?: "",
        style = TextStyle(
            color = if (message.isUser) Color.White else Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight(400)
        ),
    )
}

@Composable
fun ImageMessageItem(message: ChatMessage) {
    Image(
        painter = rememberAsyncImagePainter(message.uri),
        contentDescription = "Sent Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(150.dp)
            .clip(RoundedCornerShape(8.dp))
    )
}

@Composable
fun SuggestionMessageItem(message: ChatMessage) {
    Column {
        if (message.message1 != null) {
            Text(
                modifier = Modifier.padding(bottom = 16.dp),
                text = message.message1,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(400)
                ),
            )
        }

        if (message.doctors.isNotEmpty()) {
            Text(
                "Doctors",
                modifier = Modifier.padding(bottom = 8.dp),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600)
                )
            )

            message.doctors.forEach {
                Column(
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .fillMaxWidth()
                        .background(
                            colorResource(id = R.color.gray_100),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(16.dp)
                ) {
                    Text(
                        text = it.name,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight(400)
                        ),
                    )
                }
            }
        }

        if (message.message2 != null) {
            Text(
                text = message.message2,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(400)
                ),
            )
        }

        if (message.routines.isNotEmpty()) {
            Text(
                "Routines",
                modifier = Modifier.padding(vertical = 8.dp),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600)
                )
            )

            message.routines.forEach {
                Column(
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .fillMaxWidth()
                        .background(
                            colorResource(id = R.color.gray_100),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(16.dp)
                ) {
                    Text(
                        text = it.name,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight(400)
                        ),
                    )
                }
            }
        }

        if (message.message3 != null) {
            Text(
                text = message.message3,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(400)
                ),
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ChatListPreview() {
    val messages = listOf(
        ChatMessage(
            id = "1",
            message1 = "Hello!",
            isUser = true,
            type = ChatType.TEXT
        ),
        ChatMessage(
            id = "2",
            message1 = "",
            isUser = false,
            type = ChatType.IMAGE
        ),
        ChatMessage(
            id = "3",
            message1 = "How are you?",
            isUser = false,
            type = ChatType.TEXT
        ),
        ChatMessage(
            id = "4",
            message1 = "",
            isUser = true,
            type = ChatType.IMAGE
        ),
        ChatMessage(
            id = "5",
            message1 = "На жаль, у мене немає конкретних лікарів для ваших симптомів. Я рекомендую звернутися до суміжних спеціалістів. Вам можуть бути корисні консультації гастроентеролога для болю в животі та отоларинголога для болю в горлі.",
            isUser = false,
            type = ChatType.SUGGESTIONS,
            doctors = listOf(
                Doctor(id = "22", name = "Гастроентерологія"),
                Doctor(id = "76", name = "Оториноларингологія")
            ),
            message2 = null,
            routines = listOf(
                Routine(id = "1", name = "Routine 1"),
                Routine(id = "2", name = "Routine 2")
            ),
            message3 = "Якщо ви хочете, я можу запропонувати загальні рекомендації або запобіжні тести."
        )
    )

    val listState = rememberLazyListState()
    ChatList(messages, listState)
}