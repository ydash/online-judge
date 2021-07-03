package leetcode.codingchallenge2021.july

object MaxSumOfRectangleNoLargerThanK {
    fun maxSumSubmatrix(matrix: Array<IntArray>, k: Int): Int {
        val m = matrix.size
        val n = matrix[0].size
        var ans = Int.MIN_VALUE

        for (l in 0 until m) {
            val sums = IntArray(n)
            for (r in l until m) {
                (0 until n).forEach { sums[it] += matrix[r][it] }

                val acc = sortedSetOf(0)
                var s = 0
                for (num in sums) {
                    s += num
                    val x = acc.ceiling(s - k)
                    if (x != null) ans = maxOf(ans, s - x)
                    acc += s
                }
            }
            if (ans == k) break
        }

        return ans
    }
}