package com.thenoughtyfox.gigahackhealth.ui.appointment

import CalendarView
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kizitonwose.calendar.compose.rememberCalendarState
import com.kizitonwose.calendar.core.OutDateStyle
import com.kizitonwose.calendar.core.firstDayOfWeekFromLocale
import com.thenoughtyfox.gigahackhealth.R
import java.time.LocalDate
import java.time.YearMonth

@Composable
fun AppointmentCalendarPage(onConfirm: () -> Unit) {

    val outState = rememberScrollState()
    var selectedAddress by remember { mutableStateOf("str. Testimetianu 18/3") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.gray_100))
            .padding(horizontal = 22.dp, vertical = 16.dp)
            .verticalScroll(outState)
    ) {

        Text(
            text = "Investigații biochimice ale sângelui",
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight(600)
            )
        )

        Text(
            text = "Alege data, ora si locatie",
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight(600)
            ),
            modifier = Modifier.padding(top = 18.dp)
        )

        Text(
            text = "Locatie",
            style = TextStyle(
                color = colorResource(R.color.shadow_blue),
                fontSize = 16.sp,
                fontWeight = FontWeight(600)
            ),
            modifier = Modifier.padding(top = 16.dp)
        )

        AddressRadioButton(
            address = "str. Testimetianu 18/3",
            selectedAddress = selectedAddress,
            onAddressSelected = { selectedAddress = it }
        )
        AddressRadioButton(
            address = "str. Albisoara, 64/2",
            selectedAddress = selectedAddress,
            onAddressSelected = { selectedAddress = it }
        )
        AddressRadioButton(
            address = "str. Alecu Russo, 61/6",
            selectedAddress = selectedAddress,
            onAddressSelected = { selectedAddress = it }
        )

        Text(
            text = "Data si ora",
            style = TextStyle(
                color = colorResource(R.color.shadow_blue),
                fontSize = 14.sp,
                fontWeight = FontWeight(600)
            ),
            modifier = Modifier.padding(top = 16.dp)
        )

        val currentMonth = remember { YearMonth.now() }
        val startMonth = remember { currentMonth.minusMonths(100) } // Adjust as needed
        val endMonth = remember { currentMonth.plusMonths(100) } // Adjust as needed
        val firstDayOfWeek = remember { firstDayOfWeekFromLocale() } // Available from the library
        var selectedDate by remember { mutableStateOf<LocalDate?>(null) }

        val state = rememberCalendarState(
            startMonth = startMonth,
            endMonth = endMonth,
            firstVisibleMonth = currentMonth,
            firstDayOfWeek = firstDayOfWeek,
            outDateStyle = OutDateStyle.EndOfGrid
        )

        CalendarView(state, selectedDate, onDateSelected = { selectedDate = it })

        Time(outState) { }

        Box(
            modifier = Modifier
                .padding(top = 48.dp)
                .fillMaxWidth()
                .background(
                    color = colorResource(R.color.picton_blue_500),
                    shape = RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(16.dp))
                .clickable { onConfirm.invoke() },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Confirma programarea",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600)
                ),
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun AddressRadioButton(
    address: String,
    selectedAddress: String,
    onAddressSelected: (String) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            colors = RadioButtonDefaults.colors(
                selectedColor = colorResource(R.color.picton_blue_500),
                unselectedColor = Color.Gray
            ),
            selected = (address == selectedAddress),
            onClick = { onAddressSelected(address) }
        )
        Text(
            text = address,
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight(500)
            ),
        )
    }
}

@Composable
private fun Time(outState: ScrollState, onClickItem: () -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .padding(top = 16.dp)
            .heightIn(max = 1000.dp)
            .nestedScroll(connection = object : NestedScrollConnection {
                override fun onPreScroll(
                    available: Offset,
                    source: NestedScrollSource
                ): Offset {
                    if (outState.canScrollForward && available.y < 0) {
                        val consumed = outState.dispatchRawDelta(-available.y)
                        return Offset(x = 0f, y = -consumed)
                    }
                    return Offset.Zero
                }
            }),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(4) {
            Box(
                modifier = Modifier.background(
                    shape = RoundedCornerShape(16.dp),
                    color = Color.White
                ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "10:00",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400)
                    ),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewAppointmentCalendarPage() {
    AppointmentCalendarPage({})
}