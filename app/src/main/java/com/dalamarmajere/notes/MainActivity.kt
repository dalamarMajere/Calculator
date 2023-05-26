package com.dalamarmajere.notes

import android.content.res.Resources.Theme
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dalamarmajere.notes.logic.CalculatorViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dalamarmajere.notes.ui.components.CalculatingField
import com.dalamarmajere.notes.ui.components.CalculatorButton
import com.dalamarmajere.notes.ui.components.TopBar
import com.dalamarmajere.notes.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesTheme {
                Scaffold(
                    topBar = { TopBar()},
                    content = {
                        val viewModel = viewModel<CalculatorViewModel>()
                        val state = viewModel.state

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                        )
                        {
                            CalculatingField(state)
                            Column(modifier = Modifier
                                .fillMaxWidth()
                                .padding(it)
                                .background(DarkGray)
                            ) {
                                ButtonsLine(listOf("AC", "Del", "%", "/"), Modifier.weight(0.2f), viewModel)
                                ButtonsLine(listOf("7", "8", "9", "x"), Modifier.weight(0.2f), viewModel)
                                ButtonsLine(listOf("4", "5", "6", "-"), Modifier.weight(0.2f), viewModel)
                                ButtonsLine(listOf("1", "2", "3", "+"), Modifier.weight(0.2f), viewModel)
                                ButtonsLine(listOf("00", "0", ".", "="), Modifier.weight(0.2f), viewModel)
                            }
                        }
                    }
                )
            }
        }
    }
}


@Composable
fun ButtonsLine(
    list: List<String>,
    modifier: Modifier,
    viewModel: CalculatorViewModel
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        CalculatorButton(
            text = list[0],
            shape = RoundedCornerShape(5.dp),
            onCLick = {viewModel.enter(list[0])},
            modifier = Modifier.weight(0.25f),
            backgroundButtonColor = Color.Transparent,
            textColor = LightGray
        )
        CalculatorButton(
            text = list[1],
            shape = RoundedCornerShape(5.dp),
            onCLick = {viewModel.enter(list[1])},
            modifier = Modifier.weight(0.25f),
            backgroundButtonColor = Color.Transparent,
            textColor = LightGray
        )
        CalculatorButton(
            text = list[2],
            shape = RoundedCornerShape(5.dp),
            onCLick = {viewModel.enter(list[2])},
            modifier = Modifier.weight(0.25f),
            backgroundButtonColor = Color.Transparent,
            textColor = LightGray
        )
        CalculatorButton(
            text = list[3],
            shape = CircleShape,
            onCLick = {viewModel.enter(list[3])},
            modifier = Modifier.weight(0.25f),
            backgroundButtonColor = if (list[3] == "=") Orange else LightGray,
            textColor = if (list[3] == "=") LightGray else DarkGray
        )
    }
}