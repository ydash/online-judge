package leetcode.codingchallenge2021.may

class NumMatrix(matrix: Array<IntArray>) {
    private val m = matrix
    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int =
        (row1..row2).fold(0) { acc1, i ->
            (col1..col2).fold(acc1) { acc2, j ->
                acc2 + m[i][j]
            }
        }
}
