package com.thenoughtyfox.gigahackhealth.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.thenoughtyfox.gigahackhealth.R
import com.thenoughtyfox.gigahackhealth.ui.theme.GigahackHealthTheme

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    titleText: String,
    leftItem: @Composable () -> Unit = {},
    rightItem: @Composable () -> Unit = {},
) = ConstraintLayout(
    modifier = modifier.fillMaxWidth()
) {
    val (leftButton, title, rightButton) = createRefs()

    Box(modifier = Modifier.constrainAs(leftButton) {
        centerVerticallyTo(parent)
        start.linkTo(parent.start)
    }) { leftItem() }

    Text(
        text = titleText,
        modifier = Modifier.constrainAs(title) {
            centerTo(parent)
        },
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight(600),
            textAlign = TextAlign.Center,
            color = colorResource(R.color.black)
        )
    )

    Box(modifier = Modifier.constrainAs(rightButton) {
        centerVerticallyTo(parent)
        end.linkTo(parent.end)
    }) { rightItem() }
}

@Composable
fun ClickableIcon(
    painter: Painter, onClick: () -> Unit, color: Color, modifier: Modifier = Modifier
) {
    Icon(
        modifier = modifier
            .size(24.dp)
            .clip(CircleShape)
            .clickable { onClick() },
        painter = painter,
        contentDescription = null,
        tint = color
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() = GigahackHealthTheme {
    TopBar(titleText = "Test", leftItem = {
        Image(
            painter = painterResource(id = R.drawable.ic_left),
            contentDescription = "Back",
        )
    })
}