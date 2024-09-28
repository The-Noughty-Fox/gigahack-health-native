import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kizitonwose.calendar.compose.CalendarState
import com.kizitonwose.calendar.compose.HorizontalCalendar
import com.kizitonwose.calendar.compose.rememberCalendarState
import com.kizitonwose.calendar.core.CalendarDay
import com.kizitonwose.calendar.core.DayPosition
import com.kizitonwose.calendar.core.OutDateStyle
import com.kizitonwose.calendar.core.firstDayOfWeekFromLocale
import com.thenoughtyfox.gigahackhealth.R
import java.time.LocalDate
import java.time.YearMonth

@Composable
fun CalendarView(
    state: CalendarState,
    selectedDate: LocalDate?,
    onDateSelected: (LocalDate?) -> Unit
) {
    HorizontalCalendar(
        modifier = Modifier.padding(top = 16.dp),
        state = state,
        dayContent = {
            Day(it, isSelected = selectedDate == it.date) {
                onDateSelected.invoke(it.date)
            }
        },
        monthHeader = { month ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = month.yearMonth.month.name,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(590),
                        color = colorResource(R.color.black)
                    ),
                )

                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.ic_chevron_right),
                    contentDescription = "navigate to previous month",
                    modifier = Modifier.size(24.dp),
                    tint = colorResource(R.color.picton_blue_500)
                )
            }
            // You may want to use `remember {}` here so the mapping is not done
            // every time as the days of week order will never change unless
            // you set a new value for `firstDayOfWeek` in the state.
            val daysOfWeek = month.weekDays.first().map { it.date.dayOfWeek }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                for (dayOfWeek in daysOfWeek) {
                    Text(
                        style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight(510)),
                        text = dayOfWeek.name.take(1).uppercase(),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(1f),
                        color = colorResource(R.color.gray_700),
                    )
                }
            }
        }
    )
}

@Composable
private fun Day(
    day: CalendarDay,
    isSelected: Boolean = false,
    isBusy: Boolean = false,
    onClick: (CalendarDay) -> Unit = {}
) {
    if (day.position != DayPosition.MonthDate) return

    val color = if (isSelected) {
        colorResource(R.color.picton_blue_500)
    } else if (isBusy) {
        colorResource(R.color.gray_300)
    } else {
        colorResource(R.color.gray_200)
    }

    Box(
        modifier = Modifier
            .padding(2.dp)
            .aspectRatio(1f)
            .background(
                shape = RoundedCornerShape(CornerSize(8.dp)),
                color = color,
            )
            .clip(RoundedCornerShape(CornerSize(8.dp)))
            .clickable(
                onClick = { onClick(day) }
            ),
        contentAlignment = Alignment.Center
    ) {
        val textColor = if (isSelected || isBusy) {
            colorResource(R.color.white)
        } else {
            colorResource(R.color.black)
        }

        Text(
            text = day.date.dayOfMonth.toString(),
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                color = textColor
            ),
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CalendarPreview() {
    val currentMonth = remember { YearMonth.now() }
    val startMonth = remember { currentMonth.minusMonths(100) } // Adjust as needed
    val endMonth = remember { currentMonth.plusMonths(100) } // Adjust as needed
    val firstDayOfWeek = remember { firstDayOfWeekFromLocale() } // Available from the library

    val state = rememberCalendarState(
        startMonth = startMonth,
        endMonth = endMonth,
        firstVisibleMonth = currentMonth,
        firstDayOfWeek = firstDayOfWeek,
        outDateStyle = OutDateStyle.EndOfGrid
    )

    CalendarView(
        state = state,
        selectedDate = LocalDate.now(),
        onDateSelected = {}
    )
}