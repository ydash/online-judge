package leetcode.codingchallenge2021.june

object RemoveAllAdjacentDuplicatesInString {
    fun removeDuplicates(s: String): String {
        val queue = ArrayDeque<Char>()

        s.forEach { c ->
            if (queue.isNotEmpty() && queue.last() == c) queue.removeLast()
            else queue += c
        }
        return queue.joinToString("")
    }
}