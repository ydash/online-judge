package leetcode.codingchallenge2021.may

class NumMatrix(matrix: Array<IntArray>) {
    private val maxRowInd = matrix.size
    private val maxColInd = matrix[0].size
    val dp = Array(maxRowInd + 1) { IntArray(maxColInd + 1) }.also {
        (0 until maxRowInd).forEach { i ->
            (0 until maxColInd).forEach { j ->
                it[i + 1][j + 1] = matrix[i][j] + it[i + 1][j] + it[i][j + 1] - it[i][j]
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int =
        dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1]
}
