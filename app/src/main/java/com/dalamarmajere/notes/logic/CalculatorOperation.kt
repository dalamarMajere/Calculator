package com.dalamarmajere.notes.logic

sealed class CalculatorOperation(val text: String) {
    object Addition : CalculatorOperation("+")
    object Subtraction : CalculatorOperation("-")
    object Multiplier : CalculatorOperation("*")
    object Divider : CalculatorOperation("/")
    object Percent : CalculatorOperation("%")
}