package com.dalamarmajere.notes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(
    text: String,
    shape: Shape,
    onCLick: () -> Unit,
    backgroundButtonColor: Color,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = onCLick,
            shape = shape,
            colors = ButtonDefaults.buttonColors(backgroundColor = backgroundButtonColor),
            elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp)
        ) {
            Text(
                text = text,
                fontSize = 32.sp,
                color = textColor
            )
        }
    }
}