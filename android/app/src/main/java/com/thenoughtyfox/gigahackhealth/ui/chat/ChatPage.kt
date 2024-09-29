package com.thenoughtyfox.gigahackhealth.ui.chat

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.thenoughtyfox.gigahackhealth.R
import kotlinx.coroutines.launch

@Composable
fun ChatPage() {
    val chatViewModel: ChatViewModel = hiltViewModel()
    var message by remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    val imagePickerLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let {
                scope.launch {
                    chatViewModel.event.send(Event.SendUri(it))
                }
            }
        }


    LaunchedEffect(Unit) {
        chatViewModel.event.send(Event.GetToken)
    }

    Scaffold(
        contentColor = colorResource(id = R.color.gray_100),
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.gray_100))
            .padding(horizontal = 22.dp, vertical = 8.dp),
        topBar = {
            Box(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth()
                    .background(color = colorResource(id = R.color.gray_100)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Chat with AI Assistant",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(600),
                        color = Color.Black
                    )
                )
            }

        },
        bottomBar = {
            ChatInputBar(
                message = message,
                onMessageChange = {
                    message = it
                },
                onSendClicked = {
                    scope.launch {
                        chatViewModel.event.send(Event.SendMessage(message.text))
                        message = TextFieldValue("")
                    }
                },
                onImageClicked = {
                    imagePickerLauncher.launch("image/*") // Launch image picker
                }
            )
        }, content = { padding ->
            val state by chatViewModel.state.collectAsState()
            val listState = rememberLazyListState()

            LaunchedEffect(state.chatMessages) {
                if (state.chatMessages.isNotEmpty())
                    listState.animateScrollToItem(0)
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(id = R.color.gray_100))
                    .padding(
                        bottom = padding.calculateBottomPadding(),
                        top = padding.calculateTopPadding()
                    )
            ) {
                ChatList(state.chatMessages, listState)
            }
        })
}

@Composable
fun ChatInputBar(
    modifier: Modifier = Modifier,
    message: TextFieldValue,
    onMessageChange: (TextFieldValue) -> Unit,
    onSendClicked: () -> Unit,
    onImageClicked: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White, CircleShape)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onImageClicked) {
            Icon(
                tint = colorResource(R.color.picton_blue_500),
                painter = painterResource(R.drawable.ic_camera),
                contentDescription = "Send image"
            )
        }

        var nameEditable: String by remember { mutableStateOf("") }

        BasicTextField(
            value = message,
            onValueChange = { text ->
                nameEditable = text.toString()
                onMessageChange(text)
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .weight(1f)
                .background(Color.White, CircleShape)
                .padding(8.dp),
            decorationBox = { innerTextField ->
                if (nameEditable.isEmpty()) {
                    Text(
                        text = "Message",
                        style = TextStyle(
                            color = colorResource(R.color.picton_blue_200),
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }

                innerTextField()
            }
        )

        Spacer(modifier = Modifier.width(8.dp))

        IconButton(onClick = onSendClicked) {
            Image(
                painter = painterResource(R.drawable.ic_send),
                contentDescription = "Send message"
            )
        }
    }
}

@Preview
@Composable
private fun ChatScreenPreview() {
    ChatPage()
}