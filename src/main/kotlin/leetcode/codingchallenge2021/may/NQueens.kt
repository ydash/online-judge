package leetcode.codingchallenge2021.may

import kotlin.math.absoluteValue

object NQueens {
    fun solveNQueens(n: Int): List<List<String>> = solve(n, 0, emptyList()).map { visualize(n, it) }

    private fun visualize(n: Int, board: List<Pair<Int, Int>>): List<String> =
        board.map { (x, _) -> StringBuffer(".".repeat(n)).apply { setCharAt(x, 'Q') }.toString() }

    private fun solve(n: Int, i: Int, acc: List<Pair<Int, Int>>): List<List<Pair<Int, Int>>> =
        if (i >= n) listOf(acc)
        else {
            (0 until n).filter { canPlace(acc, Pair(it, i)) }.flatMap { solve(n, i + 1, acc + Pair(it, i)) }
        }

    fun canPlace(placed: List<Pair<Int, Int>>, coordinate: Pair<Int, Int>): Boolean =
        !coordinate.let { (a, b) ->
            placed.any { (x, y) ->
                a == x || b == y || (a - x).absoluteValue == (b - y).absoluteValue
            }
        }
}
