package leetcode.codingchallenge2021.june

object NumberOfMatchingSubsequences {
    fun numMatchingSubseq(s: String, words: Array<String>): Int {
        val dic = Array('z' - 'a' + 1) { ArrayDeque<String>() }
        words.forEach { str ->
            val i = str[0] - 'a'
            dic[i].addLast(str.drop(1))
        }
        var count = 0

        s.forEach { c ->
            val queue = dic[c - 'a']
            repeat(queue.size) {
                val str = queue.removeFirst()
                if (str.isEmpty()) ++count
                else dic[str[0] - 'a'].addLast(str.drop(1))
            }
        }

        return count
    }
}