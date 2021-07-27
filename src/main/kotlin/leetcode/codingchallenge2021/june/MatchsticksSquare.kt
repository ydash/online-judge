package leetcode.codingchallenge2021.june

object MatchsticksSquare {
    private const val FOUR = 4

    fun makesquare(matchsticks: IntArray): Boolean {
        val sum = matchsticks.sum()
        if (sum % FOUR != 0) return false
        val target = sum / FOUR
        for (l in matchsticks) if (l > target) return false

        matchsticks.sortDescending()

        return solver(matchsticks, target)
    }

    private fun solver(matchsticks: IntArray, target: Int): Boolean {
        fun loop(i: Int, a: Int, b: Int, c: Int, d: Int): Boolean =
            if (i >= matchsticks.size) a == b && b == c && c == d
            else (a + matchsticks[i] <= target && loop(i + 1, a + matchsticks[i], b, c, d)) ||
                    (b + matchsticks[i] <= target && loop(i + 1, a, b + matchsticks[i], c, d)) ||
                    (c + matchsticks[i] <= target && loop(i + 1, a, b, c + matchsticks[i], d)) ||
                    (d + matchsticks[i] <= target && loop(i + 1, a, b, c, d + matchsticks[i]))

        return loop(0, 0, 0, 0, 0)
    }
}
