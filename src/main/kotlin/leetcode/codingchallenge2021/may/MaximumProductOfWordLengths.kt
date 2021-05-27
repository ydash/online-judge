package leetcode.codingchallenge2021.may

object MaximumProductOfWordLengths {
    fun maxProduct(words: Array<String>): Int {
        var max = 0
        words.indices.forEach { i ->
            var threshold = max / words[i].length
            (i + 1 until words.size).forEach { j ->
                if (words[j].length > threshold && !words[i].any { words[j].contains(it) }) {
                    max = words[i].length * words[j].length
                    threshold = max / words[i].length
                }
            }
        }
        return max
    }
}
