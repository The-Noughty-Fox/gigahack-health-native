package com.thenoughtyfox.gigahackhealth.ui.appointment

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.thenoughtyfox.gigahackhealth.R
import org.openapitools.client.models.EmployeeApiInfo
import org.openapitools.client.models.EntityApiInfo
import kotlin.random.Random

@Composable
fun AppointmentInfoPage(
    state: State,
    isConsult: Boolean = false,
    onClickItem: () -> Unit = {},
    askInvitroBot: () -> Unit = {},
    viewModel: AppointmentViewModel = hiltViewModel()
) {

    val outState = rememberScrollState()
    var selectedType by remember { mutableStateOf(SelectedType.CATEGORY) }
    var specialityId by remember { mutableIntStateOf(0) }

    val modifier = if (selectedType != SelectedType.DOCTORS) {
        Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.gray_100))
            .padding(horizontal = 22.dp)
            .verticalScroll(outState)
    } else {
        Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.gray_100))
            .padding(horizontal = 22.dp)

    }
    Column(
        modifier = modifier
    ) {

        Row(
            modifier = Modifier.padding(top = 16.dp).clickable { askInvitroBot() },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_ask_ai_bot),
                contentDescription = null,
                modifier = Modifier.size(21.5.dp)
            )

            Text(
                text = "Ask InvitroBot",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = colorResource(R.color.picton_blue_500),
                    fontWeight = FontWeight(600)
                ), modifier = Modifier.padding(start = 16.dp)
            )
        }

        val title = when (selectedType) {
            SelectedType.CATEGORY -> "Selecteaza categorie"
            SelectedType.DOCTORS -> "Selecteaza doctor"
            SelectedType.CONSULT -> "Selecteaza consultatie"
            SelectedType.ANALYSIS -> "Selecteaza tip de analiza"
        }

        Text(
            text = title,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            ),
            modifier = Modifier.padding(top = 16.dp)
        )

        when (selectedType) {
            SelectedType.CATEGORY -> {
                Categories(state, outState, onClickItem = {
                    selectedType = SelectedType.DOCTORS
                    specialityId = it.id ?: 0
                })
            }

            SelectedType.DOCTORS -> {
                Doctors(specialityId, state = state, onClickItem = {
                    selectedType = SelectedType.CONSULT
                    viewModel.getAbilities(it.executorId ?: 0, abi = {
                        it
                    })
                    //TODO
                })
            }

            SelectedType.CONSULT -> {
                Consult(onClickItem = {
                    onClickItem.invoke()
                })
            }

            SelectedType.ANALYSIS -> {
                Analysis(state, onClickItem = {
                    onClickItem.invoke()
                })
            }
        }
    }
}

@Composable
private fun Categories(state: State, outState: ScrollState, onClickItem: (EntityApiInfo) -> Unit) {
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
        items(state.specialities) {
            ListItem(onClickItem, it)
        }
    }
}

@Composable
private fun Doctors(
    specialityId: Int,
    onClickItem: (EmployeeApiInfo) -> Unit,
    state: State
) {
    LazyColumn(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val employees = state.employees.filter {
            it.specialities?.mapNotNull { it.id }?.contains(specialityId) == true
        }

        items(employees) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .clip(RoundedCornerShape(20.dp))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(
                            bounded = true,
                            color = colorResource(R.color.picton_blue_500),
                        ),
                        onClick = { onClickItem(it) }
                    )
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            ) {
                val (image, text) = createRefs()

                Image(
                    painter = painterResource(R.drawable.ic_placeholder_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .constrainAs(image) {
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                        }
                )

                Column(modifier = Modifier.constrainAs(text) {
                    top.linkTo(image.top)
                    bottom.linkTo(image.bottom)
                    start.linkTo(image.end, margin = 24.dp)
                }) {
                    Text(
                        text = it.fullName.toString(),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(600),
                            color = Color.Black
                        ),
                    )

                    Text(
                        text = it.specialities?.first { it.id == specialityId }?.name.toString(),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            color = Color.Black
                        )
                    )
                }

            }
        }
    }
}

@Composable
private fun Consult(onClickItem: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        repeat(6) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .clip(RoundedCornerShape(20.dp))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(
                            bounded = true,
                            color = colorResource(R.color.picton_blue_500),
                        ),
                        onClick = { onClickItem() }
                    )
                    .padding(horizontal = 16.dp, vertical = 22.dp)
            ) {
                Text(
                    text = "Consultație neurolog primară",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        color = Color.Black
                    ),
                )

                Text(
                    text = "550 MDL",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        color = Color.Black
                    )
                )
            }
        }
    }
}

@Composable
private fun Analysis(state: State, onClickItem: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Analize populare",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    color = colorResource(R.color.shadow_blue)
                ),
            )

            Spacer(Modifier.weight(1f))
            Icon(
                painter = painterResource(R.drawable.ic_arrow_down),
                contentDescription = null,
                tint = colorResource(R.color.picton_blue_500),
                modifier = Modifier
                    .rotate(180f)
                    .size(24.dp)
            )
        }

        state.search.forEach { entityApiInfo ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .clip(RoundedCornerShape(20.dp))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(
                            bounded = true,
                            color = colorResource(R.color.picton_blue_500),
                        ),
                        onClick = { onClickItem() }
                    )
                    .padding(horizontal = 16.dp, vertical = 22.dp)
            ) {
                Text(
                    text = entityApiInfo.name.toString(),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        color = Color.Black
                    ),
                )

                Text(
                    text = "${Random.nextInt(500, 5000)} MDL",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        color = Color.Black
                    )
                )
            }
        }
    }
}

@Composable
private fun ListItem(onClickItem: (EntityApiInfo) -> Unit, entityApiInfo: EntityApiInfo) {
    Column(
        modifier = Modifier
            .background(color = Color.White, shape = RoundedCornerShape(20.dp))
            .clip(RoundedCornerShape(20.dp))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(
                    bounded = true,
                    color = colorResource(R.color.picton_blue_500),
                ),
                onClick = { onClickItem(entityApiInfo) }
            )
            .padding(vertical = 24.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_filters),
            contentDescription = null,
            modifier = Modifier.size(32.dp)
        )

        Text(
            text = entityApiInfo.name.toString(),
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                color = Color.Black
            ),
        )
    }
}

//@Composable
//private fun SearchView(modifier: Modifier = Modifier) {
//    Surface(
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(top = 8.dp),
//        shape = RoundedCornerShape(8.dp),
//        color = Color.White,
//    ) {
//
//        var nameEditable: String by remember { mutableStateOf("") }
//
//        BasicTextField(
//            value = nameEditable,
//            onValueChange = {
//                nameEditable = it
//            },
//            keyboardOptions = KeyboardOptions.Default.copy(
//                keyboardType = KeyboardType.Text,
//                imeAction = ImeAction.Done
//            ),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp)
//                .height(48.dp),
//            textStyle = TextStyle(
//                fontSize = 14.sp,
//                color = colorResource(R.color.black)
//            ),
//            decorationBox = { innerTextField ->
//                if (nameEditable.isEmpty()) {
//                    Row(
//                        verticalAlignment = Alignment.CenterVertically,
//                    ) {
//                        Image(
//                            painter = painterResource(R.drawable.ic_search),
//                            contentDescription = null,
//                            modifier = Modifier.size(24.dp)
//                        )
//                        Text(
//                            text = "Search",
//                            style = TextStyle(
//                                color = colorResource(R.color.picton_blue_500),
//                                fontSize = 14.sp
//                            ),
//                            modifier = Modifier.padding(start = 8.dp)
//                        )
//                    }
//                }
//
//                innerTextField()
//            }
//        )
//    }
//}

enum class SelectedType {
    CATEGORY,
    DOCTORS,
    CONSULT,
    ANALYSIS
}

@Preview
@Composable
fun PreviewAppointmentListPage() {
    AppointmentInfoPage(State())
}