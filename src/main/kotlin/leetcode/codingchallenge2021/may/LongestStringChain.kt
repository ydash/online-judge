package leetcode.codingchallenge2021.may

private const val MAX_SIZE = 1000

class LongestStringChain {
    private val cache = Array(MAX_SIZE + 1) { 0 }

    fun longestStrChain(words: Array<String>): Int {
        words.sortBy { it.length }
        return words.indices.maxOf { count(it, words) }
    }

    private fun count(i: Int, words: Array<String>): Int = when (val c = cache[i]) {
        0 -> (((i + 1 until words.size)
            .filter { canChain(words[i], words[it]) }
            .maxOfOrNull { count(it, words) } ?: 0
                ) + 1)
            .also {
                this.cache[i] = it
            }
        else -> c
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
