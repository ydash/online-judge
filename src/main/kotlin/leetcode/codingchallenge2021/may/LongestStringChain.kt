package leetcode.codingchallenge2021.may

class LongestStringChain {
    private val cache = mutableMapOf<Int, Int>()

    fun longestStrChain(words: Array<String>): Int = words.indices.maxOf { count(it, words) }

    private fun count(i: Int, words: Array<String>): Int = cache.getOrElse(i) {
        ((words.indices.filter { canChain(words[i], words[it]) }.maxOfOrNull { count(it, words) } ?: 0) + 1).also {
            cache[i] = it
        }
    }

    fun canChain(word1: String, word2: String): Boolean =
        (word1.length == word2.length + 1) && run {
            var i = 0
            var j = 0
            while (i < word1.length && j < word2.length) {
                if (word1[i] == word2[j]) {
                    j++
                }
                i++
            }
            (i == word1.length && j == word2.length) || (i == word1.length - 1 && j == word2.length)
        }
}
