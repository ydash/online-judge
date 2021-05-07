package leetcode.codingchallenge2021.may

class DeleteOperationForTwoStrings {
    fun minDistance(word1: String, word2: String): Int {
        val m = word1.length
        val n = word2.length

        val dp = Array(m + 1) { i ->
            Array(n + 1) { j ->
                when {
                    i == 0 -> j
                    j == 0 -> i
                    else -> 0
                }
            }
        }

        (1..m).forEach { i ->
            (1..n).forEach { j ->
                if (word1[i - 1] == word2[j - 1]) dp[i][j] = dp[i - 1][j - 1]
                else dp[i][j] =
                    kotlin.math.min(dp[i - 1][j], dp[i][j - 1]) + 1
            }
        }

        return dp[m][n]
    }
}
