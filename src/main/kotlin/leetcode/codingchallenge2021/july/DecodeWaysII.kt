package leetcode.codingchallenge2021.july

class DecodeWaysII {
    fun numDecodings(s: String): Int {
        if (s[0] == '0') return 0

        var prev: Long = 1
        var current: Long = if (s[0] == '*') 9 else 1
        (2..s.length).forEach {
            var tmp = 0L
            val sj = s[it - 2]
            val si = s[it - 1]

            if (si == '*') tmp += 9 * current
            else if (si > '0') tmp += current

            tmp += prev * countPattern(sj, si)

            prev = current
            current = tmp % MOD
        }

        return current.toInt()
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
