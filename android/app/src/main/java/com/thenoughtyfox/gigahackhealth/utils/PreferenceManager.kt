package com.thenoughtyfox.gigahackhealth.utils

import android.content.SharedPreferences
import javax.inject.Inject

const val IS_PASS_ONBOARDING = "onboarding"
const val THREAD_ID = "threadID"

class PreferenceManager @Inject constructor(private val sharedPreferences: SharedPreferences) {

    var isPassOnboarding: Boolean
        get() = sharedPreferences.getBoolean(IS_PASS_ONBOARDING, false)
        set(value) = sharedPreferences.edit().putBoolean(IS_PASS_ONBOARDING, value).apply()

    var threadId: String
        get() = sharedPreferences.getString(THREAD_ID, "") ?: ""
        set(value) = sharedPreferences.edit().putString(THREAD_ID, value).apply()

}