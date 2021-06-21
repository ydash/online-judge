package leetcode.codingchallenge2021.june

object PascalsTriangle {
    fun generate(numRows: Int): List<List<Int>> {
        val result = mutableListOf(arrayListOf(1))

        (1 until numRows).forEach { n ->
            val prev = result.last()
            val current = arrayListOf<Int>()
            (0..n).forEach { i ->
                current += if (i == 0 || i == n) 1 else prev[i - 1] + prev[i]
            }
            result += current
        }

        return result
    }
}