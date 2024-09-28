package com.thenoughtyfox.gigahackhealth.ui.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thenoughtyfox.gigahackhealth.R

@Composable
internal fun BottomButtons(
    modifier: Modifier = Modifier,
    currentIndex: Int,
    pagesCount: Int,
    onNextPress: () -> Unit = {},
    onFinishPress: () -> Unit = {},
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        val isLastPage = currentIndex == (pagesCount - 1)

        Box(
            modifier = Modifier
                .height(56.dp)
                .weight(1f)
                .clip(RoundedCornerShape(8.dp))
                .background(
                    if (isLastPage) colorResource(R.color.picton_blue_500) else colorResource(
                        R.color.picton_blue_100
                    )
                )
                .clickable(onClick = if (isLastPage) onFinishPress else onNextPress),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (isLastPage) "Get started" else "Next",
                style = TextStyle(
                    color = if (isLastPage) Color.White else colorResource(R.color.picton_blue_500),
                    fontWeight = FontWeight(700)
                )
            )
        }

    }
}

@Preview
@Composable
private fun Preview() = MaterialTheme {
    var currentIndex by remember {
        mutableIntStateOf(0)
    }
    BottomButtons(
        currentIndex = currentIndex,
        pagesCount = 3,
        onNextPress = { currentIndex++ },
    )
}