package leetcode.codingchallenge2021.july

class ReshapeTheMatrix {
    fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        val m = mat.size
        val n = mat[0].size

        if (m == r && n == c || m * n != r * c) return mat

        val ans = Array(r) { IntArray(c) }
        (0 until (r * c)).forEach {
            ans[it / c][it % c] = mat[it / n][it % n]
        }

        return ans
    }
}
