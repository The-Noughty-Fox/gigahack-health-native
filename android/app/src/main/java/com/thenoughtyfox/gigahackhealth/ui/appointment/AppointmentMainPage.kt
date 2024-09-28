package com.thenoughtyfox.gigahackhealth.ui.appointment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.thenoughtyfox.gigahackhealth.R

@Composable
fun AppointmentPage(onPageClicked: (AppointmentPage) -> Unit = {}) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.gray_100))
            .padding(horizontal = 22.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(R.drawable.image_appointment), contentDescription = null,
            modifier = Modifier.size(352.dp)
        )

        Text(
            text = "Alege ce tip de programare ai nevoie.",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                color = Color.Black
            ),
        )

        Spacer(modifier = Modifier.padding(top = 41.dp))
        AppointmentPage.entries.forEach {
            Page(it, onClick = { page ->
                onPageClicked.invoke(page)
            })
        }
    }
}

@Composable
private fun Page(page: AppointmentPage, onClick: (AppointmentPage) -> Unit) {
    ConstraintLayout(
        modifier = Modifier
            .padding(top = 16.dp)
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(
                    bounded = true,
                    color = colorResource(R.color.picton_blue_500),
                ),
                onClick = { onClick.invoke(page) }
            )
            .padding(16.dp)

    ) {
        val (icon, title, button) = createRefs()
        Image(painter = painterResource(page.icon), contentDescription = null,
            modifier = Modifier
                .size(32.dp)
                .constrainAs(icon) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                })

        Text(text = page.title,
            style = TextStyle(fontSize = 14.sp, color = Color.Black),
            modifier = Modifier.constrainAs(title) {
                top.linkTo(icon.top)
                bottom.linkTo(icon.bottom)
                start.linkTo(icon.end, margin = 8.dp)
            })

        Icon(
            painter = painterResource(R.drawable.ic_chevron_right),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .constrainAs(button) {
                    top.linkTo(icon.top)
                    bottom.linkTo(icon.bottom)
                    end.linkTo(parent.end)
                },
            tint = colorResource(R.color.picton_blue_500)
        )
    }
}

enum class AppointmentPage(val icon: Int, val title: String) {
    CONSULT(icon = R.drawable.ic_medecine, title = "Consultaite la medic"),
    INVESTIGATE(icon = R.drawable.ic_medecine, title = "Investigatie medicala"),
    ANALISE(icon = R.drawable.ic_medecine, title = "Analisa medicala"),
}

@Preview
@Composable
fun PreviewAppointmentPage() {
    AppointmentPage()
}