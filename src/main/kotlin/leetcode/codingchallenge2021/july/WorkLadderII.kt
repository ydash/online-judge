package leetcode.codingchallenge2021.july

class WorkLadderII {
    fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        val indexOfEndWord = wordList.indexOf(endWord)
        if (indexOfEndWord == -1) return emptyList()

        val dict = wordList.toSet()
        val seen = mutableMapOf(beginWord to 0)
        val adj = mutableMapOf<String, MutableList<String>>()
        val queue = ArrayDeque<String>()
        queue += beginWord

        while (queue.isNotEmpty() && queue.first() != endWord) {
            val word = queue.removeFirst()
            word.indices.forEach { i ->
                ('a'..'z').forEach { c ->
                    val adjWord = StringBuilder(word).apply { this[i] = c }.toString()
                    if (dict.contains(adjWord) && seen[word]!! < seen[adjWord] ?: Int.MAX_VALUE) {
                        when (val l = adj[word]) {
                            null -> adj += word to mutableListOf(adjWord)
                            else -> l += adjWord
                        }
                        if (!seen.contains(adjWord)) {
                            seen[adjWord] = seen[word]!! + 1
                            queue += adjWord
                        }
                    }
                }
            }
        }

        val ans = mutableListOf<List<String>>()
        fun dfs(current: String, acc: List<String>): Unit =
            if (current == endWord) ans += acc
            else when (val next = adj[current]) {
                null -> {
                }
                else -> next.forEach { dfs(it, acc + it) }
            }
        dfs(beginWord, listOf(beginWord))
        return ans
    }
}
