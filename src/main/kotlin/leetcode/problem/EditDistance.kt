package leetcode.problem

class EditDistance {
    fun minDistance(word1: String, word2: String): Int {
        val m = word1.length
        val n = word2.length

        val dp = IntArray(m + 1) { it }

        (1..n).forEach { j ->
            val tmp = dp.clone()
            dp[0] = j
            (1..m).forEach { i ->
                if (word1[i - 1] == word2[j - 1]) dp[i] = tmp[i - 1]
                else dp[i] =
                    minOf(dp[i - 1], tmp[i], tmp[i - 1]) + 1
            }
        }

        return dp[m]
    }
}
