package leetcode.codingchallenge2021.june

object RemoveAllAdjacentDuplicatesInString {
    fun removeDuplicates(s: String): String {
        val ans = StringBuilder()

        s.forEach { c ->
            if (ans.isNotEmpty() && ans.last() == c) ans.deleteCharAt(ans.lastIndex)
            else ans.append(c)
        }

        return ans.toString()
    }
}