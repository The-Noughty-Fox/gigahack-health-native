package com.thenoughtyfox.gigahackhealth.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thenoughtyfox.gigahackhealth.ui.theme.GigahackHealthTheme

@Composable
fun BottomNavBar(
    selected: BottomNavData,
    modifier: Modifier = Modifier,
    onSelectTab: (BottomNavData) -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomNavData.entries.forEach { tab ->
            NavItem(
                tab = tab,
                currentlySelected = selected,
                onSelectTab = onSelectTab,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun NavItem(
    tab: BottomNavData,
    currentlySelected: BottomNavData,
    onSelectTab: (BottomNavData) -> Unit,
    modifier: Modifier = Modifier
) = Column(
    verticalArrangement = Arrangement.Center,
    modifier = modifier
        .clickable { onSelectTab(tab) }
        .height(64.dp)
        .background(color = Color.White),
    horizontalAlignment = Alignment.CenterHorizontally
) {
    val isSelected = tab == currentlySelected
    Icon(
        painter = painterResource(tab.icon),
        modifier = Modifier.size(24.dp),
        contentDescription = null,
        tint = if (isSelected) GigahackHealthTheme.colors.selected else Color.Black
    )

    Text(
        modifier = Modifier.padding(top = 4.dp),
        text = stringResource(tab.text),
        style = TextStyle(
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = if (isSelected) GigahackHealthTheme.colors.selected else Color.Black
        )
    )
}

@Preview
@Composable
private fun Preview() = GigahackHealthTheme {
    var selected: BottomNavData by remember {
        mutableStateOf(BottomNavData.Home)
    }

    BottomNavBar(selected, onSelectTab = { selected = it })
}