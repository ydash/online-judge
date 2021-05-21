package leetcode.codingchallenge2021.may


private const val LENGTH_OF_A_TO_Z = 'z' - 'a' + 1

object FindAndReplacePatternSolution {

    fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> =
        words.filter { match(pattern, it) }

    fun match(pattern: String, word: String): Boolean =
        if (pattern.length != word.length) false
        else {
            val map: Array<Char?> = Array(LENGTH_OF_A_TO_Z) { null }
            val replaced = BooleanArray(LENGTH_OF_A_TO_Z)
            pattern.indices.all { i ->
                val x = pattern[i] - 'a'
                val y = word[i] - 'a'
                if (map[x] == null && !replaced[y]) {
                    map[x] = word[i]
                    replaced[y] = true
                }
                map[x] == word[i]
            }
        }
}
