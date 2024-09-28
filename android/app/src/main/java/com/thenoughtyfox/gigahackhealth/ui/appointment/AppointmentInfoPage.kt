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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.thenoughtyfox.gigahackhealth.R

@Composable
fun AppointmentInfoPage(isConsult: Boolean = false, onClickItem: () -> Unit = {}) {

    val outState = rememberScrollState()
    var selectedType by remember { mutableStateOf(SelectedType.CATEGORY) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.gray_100))
            .padding(horizontal = 22.dp)
            .verticalScroll(outState)
    ) {

        SearchView()

        Row(
            modifier = Modifier.padding(top = 16.dp),
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
            SelectedType.CATEGORY -> Categories(outState, onClickItem = {
                selectedType = if (isConsult) {
                    SelectedType.CONSULT
                } else {
                    SelectedType.DOCTORS
                }
            })

            SelectedType.DOCTORS -> Doctors(onClickItem = {
                selectedType = SelectedType.CONSULT
            })

            SelectedType.CONSULT -> Consult(onClickItem = {
                onClickItem.invoke()
            })

            SelectedType.ANALYSIS -> Analysis(onClickItem = {
                onClickItem.invoke()
            })
        }
    }
}

@Composable
private fun Categories(outState: ScrollState, onClickItem: () -> Unit) {
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
        items(20) {
            ListItem(onClickItem)
        }
    }
}

@Composable
private fun Doctors(onClickItem: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        repeat(6) {
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
                        onClick = { onClickItem() }
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
                        text = "Dr. John Doe",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(600),
                            color = Color.Black
                        ),
                    )

                    Text(
                        text = "Medic nutriționist",
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
private fun Analysis(onClickItem: () -> Unit = {}) {
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
private fun ListItem(onClickItem: () -> Unit) {
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
                onClick = { onClickItem() }
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
            text = "Category",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                color = Color.Black
            ),
        )
    }
}

@Composable
private fun SearchView(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
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
                .padding(horizontal = 16.dp)
                .height(48.dp),
            textStyle = TextStyle(
                fontSize = 14.sp,
                color = colorResource(R.color.black)
            ),
            decorationBox = { innerTextField ->
                if (nameEditable.isEmpty()) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_search),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "Search",
                            style = TextStyle(
                                color = colorResource(R.color.picton_blue_500),
                                fontSize = 14.sp
                            ),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }

                innerTextField()
            }
        )
    }
}

enum class SelectedType {
    CATEGORY,
    DOCTORS,
    CONSULT,
    ANALYSIS
}

@Preview
@Composable
fun PreviewAppointmentListPage() {
    AppointmentInfoPage()
}