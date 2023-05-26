package com.dalamarmajere.notes.logic

data class CalculatorState(
    val firstNumber : String = "",
    val secondNumber : String = "",
    val operation: CalculatorOperation? = null
)