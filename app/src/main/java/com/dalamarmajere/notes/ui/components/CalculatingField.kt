package com.dalamarmajere.notes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dalamarmajere.notes.logic.CalculatorState
import com.dalamarmajere.notes.ui.theme.Green

@Composable
fun CalculatingField(
    state : CalculatorState
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
        .background(color = Green)
    ) {
        Text(
            text = state.firstNumber + (state.operation?.text ?: "") + state.secondNumber,
            textAlign = TextAlign.End,
            fontSize = 30.sp,
            maxLines = 2,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp)
        )
    }

}