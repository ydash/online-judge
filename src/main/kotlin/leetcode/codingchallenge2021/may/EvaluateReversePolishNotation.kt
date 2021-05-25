package leetcode.codingchallenge2021.may

import java.util.Stack

object EvaluateReversePolishNotation {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()
        tokens.forEach {
            when (it) {
                "+", "-", "*", "/" -> {
                    val operand2 = stack.pop()
                    val operand1 = stack.pop()
                    val result = calculate(it, operand1, operand2)
                    stack.push(result)
                }
                else -> stack.push(it.toInt())
            }
        }
        return stack.pop()
    }

    private fun calculate(operator: String, operand1: Int, operand2: Int): Int {
        return when (operator) {
            "+" -> operand1 + operand2
            "-" -> operand1 - operand2
            "*" -> operand1 * operand2
            else -> operand1 / operand2
        }
    }
}
