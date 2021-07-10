package leetcode.codingchallenge2021.july

class DecodeWaysII {
    fun numDecodings(s: String): Int {
        if (s[0] == '0') return 0
        val dp = LongArray(s.length + 1)

        dp[0] = 1
        dp[1] = if (s[0] == '*') 9 else 1
        (2..s.length).forEach { i ->
            val prev = s[i - 2]
            val current = s[i - 1]

            if (current == '*') dp[i] += 9 * dp[i - 1]
            else if (current > '0') dp[i] += dp[i - 1]

            dp[i] += dp[i - 2] * countPattern(prev, current)

            dp[i] %= MOD
        }

        return dp.last().toInt()
    }

    private fun countPattern(prev: Char, current: Char): Int = when (prev) {
        '*' -> when (current) {
            '*' -> 15
            in '0'..'6' -> 2
            else -> 1
        }
        '1' -> if (current == '*') 9 else 1
        '2' -> when (current) {
            '*' -> 6
            in '0'..'6' -> 1
            else -> 0
        }
        else -> 0
    }

    companion object {
        const val MOD = 1000000007L
    }
}
