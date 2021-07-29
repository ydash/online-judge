package leetcode.codingchallenge2021.july

import java.util.ArrayDeque

class ZeroOneMatrix {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val n = mat.size
        val m = mat.first().size
        val ans = Array(n) { IntArray(m) { Int.MAX_VALUE } }
        val queue = ArrayDeque<Pair<Int, Int>>()
        for (i in mat.indices) {
            for (j in mat[i].indices) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0
                    queue += i to j
                }
            }
        }

        while (queue.isNotEmpty()) {
            val (i, j) = queue.removeFirst()
            listOf(i - 1 to j, i + 1 to j, i to j - 1, i to j + 1)
                .filter { (x, y) -> 0 <= x && 0 <= y && x < n && y < m }
                .forEach { (x, y) ->
                    val dist = if (mat[x][y] == 0) 0 else ans[i][j] + 1
                    if (dist < ans[x][y]) {
                        ans[x][y] = dist
                        queue += x to y
                    }
                }
        }

        return ans
    }
}
