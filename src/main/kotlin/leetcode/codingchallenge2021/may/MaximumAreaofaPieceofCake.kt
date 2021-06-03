package leetcode.codingchallenge2021.may

const val DIVISOR = 1000000007

object MaximumAreaofaPieceofCake {
    fun maxArea(h: Int, w: Int, horizontalCuts: IntArray, verticalCuts: IntArray): Int {
        var ans = 0
        val current = IntArray(w) { 1 }
        val prev = IntArray(w)
        val cutH = BooleanArray(h).apply {
            horizontalCuts.forEach { this[it] = true }
        }
        val cutV = BooleanArray(w).apply {
            verticalCuts.forEach {
                this[it] = true
            }
        }
        for (i in 0 until h) {
            for (j in 0 until w) {
                when {
                    i == 0 && j == 0 -> current[0] = 1
                    i == 0 -> current[j] = if (!cutV[j]) current[j - 1] + 1 else 1
                    j == 0 -> current[j] = if (!cutH[i]) prev[j] + 1 else 1
                    cutH[i] && cutV[j] -> current[j] = 1
                    cutH[i] -> current[j] = current[j - 1] + 1
                    cutV[j] -> current[j] = prev[j] + 1
                    else -> current[j] = current[j - 1] - prev[j - 1] + prev[j] + 1
                }
            }
            current.indices.forEach {
                prev[it] = current[it] % DIVISOR
                ans = maxOf(ans, prev[it])
            }
        }

        return ans
    }
}
