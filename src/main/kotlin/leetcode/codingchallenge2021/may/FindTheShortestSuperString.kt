package leetcode.codingchallenge2021.may

object FindTheShortestSuperString {
    fun shortestSuperstring(words: Array<String>): String = greedy(words.toSet())

    fun greedy(words: Set<String>): String {
        val m = mutableMapOf<Int, MutableList<Triple<String, Int, Int>>>()
        val tmp = words.toTypedArray()

        tmp.indices.forEach { i ->
            ((i + 1)..tmp.lastIndex).forEach { j ->
                val (len, str) = overlap(tmp[i], tmp[j])
                m[len]?.let { it += Triple(str, i, j) }
                    ?: run { m += (len to mutableListOf(Triple(str, i, j))) }
            }
        }

        val maxOverlap = m.maxByOrNull { it.key }?.key ?: 0
        return if (maxOverlap == 0) words.joinToString("")
        else {
            val threshold = if (maxOverlap >= 2) maxOverlap - 1 else maxOverlap
            m.filterKeys { it >= threshold }.values.flatten()
                .map { (str, x, y) -> greedy(words - tmp[x] - tmp[y] + str) }
                .minByOrNull { it.length }!!
        }
    }

    fun overlap(str1: String, str2: String): Pair<Int, String> {
        var max = 0
        var res = "$str1$str2"
        for (i in 1..minOf(str1.length, str2.length)) {
            if (str1.substring(str1.length - i) == str2.substring(0, i)) {
                max = i
                res = "$str1${str2.drop(i)}"
            } else if (str1.substring(0, i) == str2.substring(str2.length - i)) {
                max = i
                res = "$str2${str1.drop(i)}"
            }
        }
        return Pair(max, res)
    }
}
