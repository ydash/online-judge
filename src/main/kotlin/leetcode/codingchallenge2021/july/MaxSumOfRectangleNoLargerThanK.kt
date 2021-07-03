package leetcode.codingchallenge2021.july

object MaxSumOfRectangleNoLargerThanK {
    fun maxSumSubmatrix(matrix: Array<IntArray>, k: Int): Int {
        val m = matrix.size
        val n = matrix[0].size
        val dp = Array(m) { Array(n) { IntArray(n) } }
        var ans = k + 1

        loop@ for (i in 0 until m) {
            for (j in 0 until n) {
                for (l in 0..j) {
                    dp[i][j][l] = if (l == 0) matrix[i][j] else dp[i][j - 1][l - 1] + matrix[i][j]
                    if (dp[i][j][l] <= k && (ans > k || k - dp[i][j][l] < k - ans)) ans = dp[i][j][l]
                    if (ans == k) break@loop
                }
            }
            for (x in 0 until i) {
                for (y in 0 until n) {
                    for (z in 0..y) {
                        dp[x][y][z] += dp[i][y][z]
                        if (dp[x][y][z] <= k && (ans > k || k - dp[x][y][z] < k - ans)) ans = dp[x][y][z]
                        if (ans == k) break@loop
                    }
                }
            }
        }

        return ans
    }
}