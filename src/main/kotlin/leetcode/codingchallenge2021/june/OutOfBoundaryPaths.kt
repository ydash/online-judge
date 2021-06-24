package leetcode.codingchallenge2021.june

object OutOfBoundaryPaths {
    fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
        var ans = 0L
        val mod = 1000000007
        val current = Array(m) { LongArray(n) }
        val prev = Array(m) { LongArray(n) }
        prev[startRow][startColumn] = 1

        repeat(maxMove) {
            (0 until m).forEach { i ->
                (0 until n).forEach { j ->
                    if (i - 1 < 0) ans += prev[i][j] else current[i - 1][j] += prev[i][j]
                    if (i + 1 >= m) ans += prev[i][j] else current[i + 1][j] += prev[i][j]
                    if (j - 1 < 0) ans += prev[i][j] else current[i][j - 1] += prev[i][j]
                    if (j + 1 >= n) ans += prev[i][j] else current[i][j + 1] += prev[i][j]
                    ans %= mod
                }
            }
            (0 until m).forEach { i ->
                (0 until n).forEach { j ->
                    prev[i][j] = current[i][j] % mod
                    current[i][j] = 0
                }
            }
        }

        return ans.toInt()
    }
}