package leetcode.codingchallenge2021.may

class NumMatrix(matrix: Array<IntArray>) {
    private val rowSize = matrix.size
    private val colSize = matrix[0].size
    private val dp = Array(rowSize + 1) { IntArray(colSize + 1) }.also {
        (0 until rowSize).forEach { i ->
            (0 until colSize).forEach { j ->
                it[i + 1][j + 1] = matrix[i][j] + it[i + 1][j] + it[i][j + 1] - it[i][j]
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int =
        dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1]
}
