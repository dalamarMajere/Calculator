package com.dalamarmajere.notes.logic

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())

    fun enter(operation: String) {
        when (operation) {
            "AC" -> {
                EraseAll()
            }
            "Del" -> { deleteNumber() }
            "%" -> { makeOperation(CalculatorOperation.Percent) }
            "/" -> { makeOperation(CalculatorOperation.Divider) }
            "0" -> { enterNumber(operation) }
            "00" -> { enterNumber(operation) }
            "1" -> { enterNumber(operation) }
            "2" -> { enterNumber(operation) }
            "3" -> { enterNumber(operation) }
            "4" -> { enterNumber(operation) }
            "5" -> { enterNumber(operation) }
            "6" -> { enterNumber(operation) }
            "7" -> { enterNumber(operation) }
            "8" -> { enterNumber(operation) }
            "9" -> { enterNumber(operation) }
            "x" -> { makeOperation(CalculatorOperation.Multiplier) }
            "=" -> { calculate() }
            "." -> { enterDecimal() }
            "+" -> { makeOperation(CalculatorOperation.Addition) }
            "-" -> { makeOperation(CalculatorOperation.Subtraction) }
            else -> {}
        }
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.firstNumber.contains(".") && state.firstNumber.isNotBlank()) {
            state = state.copy(
                firstNumber = state.firstNumber + "."
            )
            return
        }
        else
            if (!state.secondNumber.contains(".") && state.secondNumber.isNotBlank()) {
                state = state.copy(
                    secondNumber = state.secondNumber + "."
            )
        }
    }

    private fun calculate() {
        val number1 = state.firstNumber.toDoubleOrNull()
        val number2 = state.secondNumber.toDoubleOrNull()
        if(number1 != null && number2 != null) {
            val result = when(state.operation) {
                is CalculatorOperation.Addition -> number1 + number2
                is CalculatorOperation.Subtraction -> number1 - number2
                is CalculatorOperation.Multiplier -> number1 * number2
                is CalculatorOperation.Divider -> number1 / number2
                else -> return
            }
            state = state.copy(
                firstNumber = result.toString().take(15),
                secondNumber = "",
                operation = null
            )
        }
    }

    private fun makeOperation(operation: CalculatorOperation) {
        if(state.firstNumber.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun deleteNumber() {
        state = if (state.operation != null)
            if (state.secondNumber.isNotBlank())
                state.copy(secondNumber = state.secondNumber.substring(0, state.secondNumber.length - 1))
            else state.copy(operation = null)
        else
            state.copy(firstNumber = state.firstNumber.substring(0, state.firstNumber.length - 1))
    }

    private fun enterNumber(number: String) {
        state = if (state.operation != null)
            state.copy(secondNumber = state.secondNumber + number)
        else
            state.copy(firstNumber = state.firstNumber + number)
    }

    private fun EraseAll() {
        state = state.copy(firstNumber = "", secondNumber = "", operation = null)
    }
}