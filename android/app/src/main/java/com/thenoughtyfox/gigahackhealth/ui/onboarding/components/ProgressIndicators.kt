package com.thenoughtyfox.gigahackhealth.ui.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thenoughtyfox.gigahackhealth.R

@Composable
internal fun ProgressIndicators(
    modifier: Modifier = Modifier,
    currentIndex: Int,
    pagesCount: Int,
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(dotSize)) {
        List(pagesCount) {
            val isCurrent = currentIndex == it
            Box(
                modifier = Modifier
                    .height(dotSize)
                    .width(if (isCurrent) dotSize * 2 else dotSize)
                    .clip(CircleShape)
                    .background(color = if (isCurrent) colorResource(R.color.picton_blue_500) else Color(0xffd9d9d9))
            )
        }
    }
}

private val dotSize = 12.dp

@Preview
@Composable
private fun Preview() = MaterialTheme {
    ProgressIndicators(currentIndex = 1, pagesCount = 3)
}