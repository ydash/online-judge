package leetcode.codingchallenge2021.july

class ZeroOneMatrix {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val n = mat.size
        val m = mat.first().size
        val ans = Array(n) { IntArray(m) { DUMMY_DIST } }

        for (i in mat.indices) {
            for (j in mat[i].indices) {
                if (mat[i][j] == 0) ans[i][j] = 0
                else {
                    if (i > 0) ans[i][j] = minOf(ans[i][j], ans[i - 1][j] + 1)
                    if (j > 0) ans[i][j] = minOf(ans[i][j], ans[i][j - 1] + 1)
                }
            }
        }

        for (i in mat.indices.reversed()) {
            for (j in mat[i].indices.reversed()) {
                if (i < n - 1) ans[i][j] = minOf(ans[i][j], ans[i + 1][j] + 1)
                if (j < m - 1) ans[i][j] = minOf(ans[i][j], ans[i][j + 1] + 1)
            }
        }

        return ans
    }

    companion object {
        const val DUMMY_DIST = 100000000
    }
}
