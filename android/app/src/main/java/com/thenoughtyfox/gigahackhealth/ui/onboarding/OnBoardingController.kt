package com.thenoughtyfox.gigahackhealth.ui.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thenoughtyfox.gigahackhealth.ui.onboarding.components.BottomButtons
import com.thenoughtyfox.gigahackhealth.ui.onboarding.components.OnboardingPage
import com.thenoughtyfox.gigahackhealth.ui.onboarding.components.ProgressIndicators
import kotlinx.coroutines.launch

@Composable
fun OnBoardingController(
    pages: List<OnboardingPageData> = onboardingPages,
    onFinishPress: () -> Unit = {},
) {

    val state = rememberPagerState(initialPage = 0, pageCount = { pages.size })
    val scope = rememberCoroutineScope()

    Scaffold(
        containerColor = Color.White,
        topBar = {
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
            ) {
                ProgressIndicators(
                    modifier = Modifier
                        .padding(vertical = 56.dp)
                        .align(Alignment.CenterHorizontally),
                    currentIndex = state.currentPage,
                    pagesCount = state.pageCount
                )

                BottomButtons(
                    modifier = Modifier
                        .padding(16.dp)
                        .width(160.dp)
                        .align(Alignment.CenterHorizontally),
                    currentIndex = state.currentPage,
                    pagesCount = state.pageCount,
                    onNextPress = {
                        scope.launch {
                            state.animateScrollToPage(state.currentPage + 1)
                        }
                    },
                    onFinishPress = onFinishPress
                )
            }
        },
        content = { padding ->
            HorizontalPager(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
                    .padding(padding),
                state = state
            ) {
                OnboardingPage(
                    imageResId = pages[it].imageResId,
                    titleResId = pages[it].titleResId,
                    textResId = pages[it].textResId,
                )
            }
        }
    )
}

@Preview
@Composable
private fun Preview() = MaterialTheme {
    OnBoardingController()
}