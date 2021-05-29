package leetcode.codingchallenge2021.may

import kotlin.math.absoluteValue

object NQueens2 {
    fun totalNQueens(n: Int): Int {
        var currentStates = (0 until n).map { listOf(Coordinate(0, it)) }

        (1 until n).forEach { i ->
            currentStates = currentStates.flatMap { next(n, i, it) }
        }

        return currentStates.size
    }

    fun next(n: Int, x: Int, currentStates: List<Coordinate>): List<List<Coordinate>> =
        (0 until n).toList().fold(emptyList()) { acc, y ->
            if (currentStates.all { it.y != y && (it.y - y).absoluteValue != (it.x - x).absoluteValue }) {
                acc.plusElement(currentStates + Coordinate(x, y))
            } else acc
        }

}

data class Coordinate(val x: Int, val y: Int)
