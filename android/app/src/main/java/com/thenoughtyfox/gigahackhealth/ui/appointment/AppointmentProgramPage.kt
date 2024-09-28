package com.thenoughtyfox.gigahackhealth.ui.appointment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thenoughtyfox.gigahackhealth.R
import com.thenoughtyfox.gigahackhealth.ui.theme.GigahackHealthTheme
import com.thenoughtyfox.gigahackhealth.ui.view.TopBar

@Composable
fun AppointmentProgramPage(onBackPressed: ()->Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.gray_100))
            .padding(horizontal = 22.dp)
            .verticalScroll(rememberScrollState())
    ) {
        TopBar(
            titleText = "Programarea ta",
            leftItem = {
                Image(
                    painter = painterResource(R.drawable.ic_left),
                    contentDescription = null,
                    modifier = Modifier.size(62.dp).clickable { onBackPressed.invoke() }
                )
            })

        Text(
            text = "Analiza sangei generala",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                color = Color.Black
            ),
            modifier = Modifier.padding(top = 24.dp)
        )

        Text(
            text = "Data si ora",
            style = TextStyle(
                fontSize = 16.sp,
                color = colorResource(R.color.shadow_blue)
            ),
            modifier = Modifier.padding(top = 24.dp)
        )

        Column(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(20.dp)
        ) {
            Text(
                "Miercuri,  13 Octombrie\n11:00",
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight(600),
                    fontSize = 16.sp
                ),
            )
        }

        Text(
            text = "Locatie",
            style = TextStyle(
                fontSize = 16.sp,
                color = colorResource(R.color.shadow_blue)
            ),
            modifier = Modifier.padding(top = 24.dp)
        )

        Text(
            text = "str. Testimetianu 18/3",
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight(400),
            ),
            modifier = Modifier.padding(top = 8.dp)
        )

        Text(
            text = "Pret",
            style = TextStyle(
                fontSize = 16.sp,
                color = colorResource(R.color.shadow_blue)
            ),
            modifier = Modifier.padding(top = 24.dp)
        )

        Text(
            text = "550 MDL",
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight(400),
            ),
            modifier = Modifier.padding(top = 8.dp)
        )


        Text(
            text = "Notite",
            style = TextStyle(
                fontSize = 16.sp,
                color = colorResource(R.color.shadow_blue)
            ),
            modifier = Modifier.padding(top = 24.dp)
        )

        Text(
            text = "Pentru obținerea rezultatelor cu un grad înalt de exactitate recomandăm să vizitați centrul de recoltare Invitro Diagnostics între orele de dimineață 7:30 și 11.00.\u2028\n" +
                    "Sângele se prelevează din venă. Sângele venos va fi colectat de către personalul cu experiență chiar și bebelușilor.",
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight(400),
            ),
            modifier = Modifier.padding(top = 8.dp)
        )

    }
}

@Preview
@Composable
fun Preview() {
    GigahackHealthTheme {
        AppointmentProgramPage({})
    }
}