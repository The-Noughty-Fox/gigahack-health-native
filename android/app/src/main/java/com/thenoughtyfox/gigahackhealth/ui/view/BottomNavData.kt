package com.thenoughtyfox.gigahackhealth.ui.view

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.thenoughtyfox.gigahackhealth.R

enum class BottomNavData(@StringRes val text: Int, @DrawableRes val icon: Int) {
    Appointment(
        R.string.appointment_menu,
        R.drawable.ic_menu_appointment
    ),

    Home(
        R.string.home_menu,
        R.drawable.ic_menu_home
    ),

    Chat(
        R.string.chat_menu,
        R.drawable.ic_menu_chat
    ),

    Profile(
        R.string.profile_menu,
        R.drawable.ic_menu_profile
    )
}