package com.dalamarmajere.notes.ui.components

import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dalamarmajere.notes.ui.theme.Green

@Preview
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Calculator",
                color = Color.White,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        },
        backgroundColor = Green,
        elevation = 0.dp
    )
}