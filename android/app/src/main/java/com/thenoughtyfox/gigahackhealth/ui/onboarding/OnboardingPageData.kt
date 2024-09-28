package com.thenoughtyfox.gigahackhealth.ui.onboarding

import com.thenoughtyfox.gigahackhealth.R

data class OnboardingPageData(
    val imageResId: Int = R.drawable.ic_menu_profile,
    val titleResId: Int = R.string.onboarding_page_1_title,
    val textResId: Int = R.string.onboarding_text,
    val page4List: List<OnboardingPageData> = emptyList(),
)

val onboardingPages = listOf(
    OnboardingPageData(
        imageResId = R.drawable.image_onboarding_1,
        titleResId = R.string.onboarding_page_1_title,
        textResId = R.string.onboarding_text
    ),
    OnboardingPageData(
        imageResId = R.drawable.image_onboarding_2,
        titleResId = R.string.onboarding_page_title,
        textResId = R.string.onboarding_text
    ),
    OnboardingPageData(
        imageResId = R.drawable.image_onboarding_3,
        titleResId = R.string.onboarding_page_title,
        textResId = R.string.onboarding_text
    ),
)