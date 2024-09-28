package com.thenoughtyfox.gigahackhealth.ui.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thenoughtyfox.gigahackhealth.R

@Composable
fun OnboardingPage(
    imageResId: Int,
    titleResId: Int,
    textResId: Int
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(imageResId),
                contentDescription = null,
                modifier = Modifier.size(300.dp)
            )

            Text(
                text = stringResource(titleResId),
                style = TextStyle(
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                ),
                modifier = Modifier.padding(top = 24.dp)
            )

            Text(
                text = stringResource(textResId),
                style = TextStyle(
                    fontSize = 18.sp,
                    color = colorResource(R.color.gray_700),
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(top = 20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() = MaterialTheme {
    OnboardingPage(
        imageResId = R.drawable.image_onboarding_1,
        titleResId = R.string.onboarding_page_1_title,
        textResId = R.string.onboarding_text
    )
}