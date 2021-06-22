package leetcode.codingchallenge2021.june

object NumberOfMatchingSubsequences {
    fun numMatchingSubseq(s: String, words: Array<String>): Int = words.count { it.isSubsequenceOf(s) }

    private fun String.isSubsequenceOf(that: String): Boolean =
        if (this.length > that.length) false
        else {
            var i = 0
            var j = 0
            while (i < this.length && j < that.length) {
                if (this[i] == that[j]) ++i
                ++j
            }
            i == this.length
        }

//    private tailrec fun String.isSubsequenceOf(that: String): Boolean = when {
//        this.isEmpty() -> true
//        that.isEmpty() -> false
//        this[0] == that[0] -> this.drop(1).isSubsequenceOf(that.drop(1))
//        else -> this.isSubsequenceOf(that.drop(1))
//    }
}