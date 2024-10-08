package com.thenoughtyfox.gigahackhealth.ui.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.contentcapture.ContentCaptureManager.Companion.isEnabled
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import com.thenoughtyfox.gigahackhealth.R

@Composable
fun AuthPage(onButtonClicked: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 35.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_logo_invitro),
            contentDescription = "Logo",
            modifier = Modifier.size(110.dp)
        )

        Text(
            text = "Invitro Diagnostics",
            style = TextStyle(
                color = Color.Black,
                fontSize = 24.sp
            ),
            modifier = Modifier.padding(top = 24.dp)
        )

        PhoneNumberView(modifier = Modifier.padding(top = 80.dp))

        Box(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .background(
                    color = colorResource(R.color.light_blue),
                    shape = RoundedCornerShape(8.dp)
                )
                .clip(RoundedCornerShape(8.dp))
                .clickable { onButtonClicked() }
        ) {
            Text(
                text = "Continuă",
                style = TextStyle(
                    color = colorResource(R.color.blue_700),
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700)
                ),
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.Center)
            )
        }

        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 34.dp)
                .fillMaxWidth()
        ) {
            HorizontalDivider(
                color = Color.Black,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )

            Text(
                text = "OR",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp,
                ),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            HorizontalDivider(
                color = Color.Black,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = colorResource(R.color.light_blue),
                    shape = RoundedCornerShape(8.dp)
                )
                .clip(RoundedCornerShape(8.dp))
                .clickable { onButtonClicked() }
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_email),
                contentDescription = "mail",
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 8.dp)
            )

            Text(
                text = "Conectați-vă cu emailul",
                style = TextStyle(
                    color = colorResource(R.color.blue_700),
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700)
                ),
            )
        }

        Text(
            text = "Aveți deja un cont? Conectați-vă",
            style = TextStyle(
                color = colorResource(R.color.black),
                fontSize = 14.sp,
            ),
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Composable
private fun PhoneNumberView(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        border = BorderStroke(1.dp, colorResource(R.color.light_grayish_blue)),
        shape = RoundedCornerShape(8.dp),
        color = Color.White,
    ) {

        var nameEditable: String by remember { mutableStateOf("") }

        BasicTextField(
            value = nameEditable,
            onValueChange = {
                nameEditable = it
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textStyle = TextStyle(
                fontSize = 14.sp,
                color = colorResource(R.color.black)
            ),
            decorationBox = { innerTextField ->
                if (nameEditable.isEmpty()) {
                    Box {
                        Text(
                            text = "Phone number",
                            style = TextStyle(
                                color = colorResource(R.color.gray_600),
                                fontSize = 14.sp
                            ),
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                                .padding(start = 8.dp)
                        )
                    }
                }

                innerTextField()
            }
        )
    }
}

@Preview
@Composable
fun AuthPagePreview() {
    AuthPage()
}