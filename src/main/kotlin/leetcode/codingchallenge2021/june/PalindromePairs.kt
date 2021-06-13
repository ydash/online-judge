package leetcode.codingchallenge2021.june

object PalindromePairs {
    fun palindromePairs(words: Array<String>): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        val n = words.size
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                if ("${words[i]}${words[j]}".isPalindrome()) ans += listOf(i, j)
                if ("${words[j]}${words[i]}".isPalindrome()) ans += listOf(j, i)
            }
        }
        return ans
    }

    fun String.isPalindrome(): Boolean {
        var i = 0
        var j = this.length - 1
        while (i < j) {
            if (this[i] != this[j]) break
            ++i
            --j
        }
        return i >= j
    }
}