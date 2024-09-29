package com.thenoughtyfox.gigahackhealth.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.thenoughtyfox.gigahackhealth.R
import com.thenoughtyfox.gigahackhealth.ui.view.TopBar
import org.openapitools.client.models.PersonApiInfo

@Composable
fun ProfilePage(viewModel: ProfileViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()

    Column(
        Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.gray_100))
            .padding(horizontal = 22.dp)
    ) {
        TopBar(
            titleText = "Profile",
            leftItem = {
                Image(
                    painter = painterResource(R.drawable.ic_left),
                    contentDescription = null,
                    modifier = Modifier.size(62.dp)
                )
            },
            rightItem = {
                Image(
                    painter = painterResource(R.drawable.ic_notification),
                    contentDescription = null,
                    modifier = Modifier.size(62.dp)
                )
            })

        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            UserData(state.person)

            Program.entries.forEach {
                Program(it)
            }

            ProfilePage.entries.forEach {
                Page(it)
            }

            Spacer(modifier = Modifier.padding(bottom = 16.dp))
        }
    }
}

@Composable
private fun UserData(person: PersonApiInfo) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        val (name, data, icon) = createRefs()

        Text(
            text = person.firstName + " " + person.lastName,
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight(600)
            ),
            modifier = Modifier.constrainAs(name) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }
        )

        Row(
            modifier = Modifier
                .padding(top = 8.dp)
                .constrainAs(data) {
                    top.linkTo(name.bottom)
                    start.linkTo(parent.start)
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ic_calendar),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )

            Text(
                text = person.dateOfBirth ?: "",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                ),
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Image(
            painter = painterResource(R.drawable.ic_write), contentDescription = null,
            modifier = Modifier
                .size(32.dp)
                .constrainAs(icon) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                },
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun Program(type: Program) {
    ConstraintLayout(
        modifier = Modifier
            .padding(top = 16.dp)
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        val (icon, title, button, desc) = createRefs()

        Image(painter = painterResource(type.icon), contentDescription = null,
            modifier = Modifier
                .size(32.dp)
                .constrainAs(icon) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                })

        Text(text = type.title,
            style = TextStyle(fontSize = 14.sp, color = Color.Black),
            modifier = Modifier.constrainAs(title) {
                top.linkTo(icon.top)
                bottom.linkTo(icon.bottom)
                start.linkTo(icon.end, margin = 8.dp)
            })

        Surface(
            shape = RoundedCornerShape(16.dp),
            color = colorResource(R.color.picton_blue_500),
            modifier = Modifier.constrainAs(button) {
                top.linkTo(icon.top)
                bottom.linkTo(icon.bottom)
                end.linkTo(parent.end)
            }) {
            Row(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Vezi",
                    style = TextStyle(fontSize = 14.sp, color = Color.White),
                )

                Icon(
                    painter = painterResource(R.drawable.ic_chevron_right),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
        if (type == Program.PROGRAM) {
            ProgramItem(modifier = Modifier.constrainAs(desc) {
                top.linkTo(icon.bottom)
                start.linkTo(parent.start)
            })
        } else {
            Text(text = type.desc,
                style = TextStyle(fontSize = 14.sp, color = Color.Black),
                modifier = Modifier
                    .padding(top = 16.dp)
                    .constrainAs(desc) {
                        top.linkTo(icon.bottom)
                        start.linkTo(parent.start)
                    })
        }
    }
}

@Composable
private fun ProgramItem(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .padding(top = 16.dp)
            .background(
                color = colorResource(R.color.green_transparent),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp)
    ) {
        val (time, date, occupation, name, photo) = createRefs()

        Text(
            text = "11:45",
            style = TextStyle(fontSize = 16.sp, color = Color.Black, fontWeight = FontWeight(600)),
            modifier = Modifier
                .constrainAs(time) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )

        Text(
            text = "12.09",
            style = TextStyle(fontSize = 16.sp, color = Color.Black, fontWeight = FontWeight(600)),
            modifier = Modifier
                .constrainAs(date) {
                    top.linkTo(time.bottom)
                    start.linkTo(parent.start)
                }
        )

        Text(
            text = "Dermotolog",
            style = TextStyle(fontSize = 16.sp, color = Color.Black, fontWeight = FontWeight(600)),
            modifier = Modifier
                .constrainAs(occupation) {
                    top.linkTo(time.top)
                    start.linkTo(time.end, margin = 16.dp)
                }
        )

        Text(
            text = "Botnaru Doina",
            style = TextStyle(fontSize = 12.sp, color = Color.Black),
            modifier = Modifier
                .constrainAs(name) {
                    top.linkTo(occupation.bottom)
                    start.linkTo(date.end, margin = 16.dp)
                },
            textDecoration = TextDecoration.Underline
        )

        Image(
            painter = painterResource(R.drawable.ic_google),
            contentDescription = null,
            modifier = Modifier
                .size(36.dp)
                .constrainAs(photo) {
                    start.linkTo(occupation.end, margin = 50.dp)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        )
    }
}

@Composable
private fun Page(profilePage: ProfilePage) {
    ConstraintLayout(
        modifier = Modifier
            .padding(top = 16.dp)
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        val (icon, title, button) = createRefs()
        Image(painter = painterResource(profilePage.icon), contentDescription = null,
            modifier = Modifier
                .size(32.dp)
                .constrainAs(icon) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                })

        Text(text = profilePage.title,
            style = TextStyle(fontSize = 14.sp, color = Color.Black),
            modifier = Modifier.constrainAs(title) {
                top.linkTo(icon.top)
                bottom.linkTo(icon.bottom)
                start.linkTo(icon.end, margin = 8.dp)
            })

        if (profilePage != ProfilePage.LOGOUT) {
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
}

private enum class Program(val icon: Int, val title: String, val desc: String) {
    PROGRAM(
        icon = R.drawable.ic_calendar,
        title = "Programarile mele",
        desc = "Nu ai nici o programare planficata"
    ),
    HISTORY(
        icon = R.drawable.ic_book,
        title = "Istorie Medicala",
        desc = "Verifica istoria medicala"
    ),
    BONUS(
        icon = R.drawable.ic_favorite,
        title = "Bonusuri mele",
        desc = "Verifica cite bonusuri ai resuit sa acumulezi"
    )
}

private enum class ProfilePage(val icon: Int, val title: String) {
    MEDICINE(icon = R.drawable.ic_medecine, title = "Medicine & Supplements"),
    PERSONAL_INFO(icon = R.drawable.ic_profile, title = "Personal Information"),
    PROFILE_SETTINGS(icon = R.drawable.ic_settings, title = "Profile Settings"),
    RESET_PASSWORD(icon = R.drawable.ic_reset_password, title = "Reset password"),
    LOGOUT(icon = R.drawable.ic_log_out, title = "Logout")
}

@Preview
@Composable
fun ProfilePagePreview() {
    ProfilePage()
}