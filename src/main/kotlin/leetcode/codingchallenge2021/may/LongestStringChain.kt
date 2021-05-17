package leetcode.codingchallenge2021.may

class LongestStringChain {
    private val cache = mutableMapOf<Int, Int>()

    fun longestStrChain(words: Array<String>): Int {
        words.sortBy { it.length }
        return words.indices.maxOf { count(it, words) }
    }

    private fun count(i: Int, words: Array<String>): Int = cache.getOrElse(i) {
        (((i + 1 until words.size)
            .filter { canChain(words[i], words[it]) }
            .maxOfOrNull { count(it, words) } ?: 0
                ) + 1)
            .also {
                cache[i] = it
            }
    }

    fun canChain(word1: String, word2: String): Boolean =
        (word1.length + 1 == word2.length) && run {
            var i = 0
            var j = 0
            while (i < word1.length && j < word2.length) {
                if (word1[i] == word2[j]) {
                    i++
                }
                j++
            }
            (i == word1.length && j == word2.length) || (i == word1.length && j == word2.length - 1)
        }
}
