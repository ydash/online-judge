package leetcode.codingchallenge2021.june

object GenerateParentheses {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()

        fun backtrack(n: Int, open: Int, close: Int, p: String) {
            when {
                open == n && close == n -> result.add(p)
                else -> {
                    if (open < n) backtrack(n, open + 1, close, "$p(")
                    if (close < open) backtrack(n, open, close + 1, "$p)")
                }
            }
        }

        backtrack(n, 0, 0, "")
        return result
    }

}