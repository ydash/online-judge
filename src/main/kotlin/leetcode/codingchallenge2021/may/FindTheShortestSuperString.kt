package leetcode.codingchallenge2021.may

object FindTheShortestSuperString {
    fun shortestSuperstring(words: Array<String>): String {
        return words.indices.toList().permutation().flatMap { p ->
            p.drop(1).fold(listOf(words[p[0]])) { acc, i ->
                acc.flatMap { merge(it, words[i]) }
            }
        }.minByOrNull { it.length }!!
    }

    fun merge(str1: String, str2: String): List<String> {
        val buf = mutableListOf("$str1$str2", "$str2$str1")
        if (str1.contains(str2) || str2.contains(str1)) buf += str1
        for (i in 1..minOf(str1.length, str2.length)) {
            if (str1.substring(str1.length - i) == str2.substring(0, i)) buf += "$str1${str2.drop(i)}"
            if (str1.substring(0, i) == str2.substring(str2.length - i)) buf += "$str2${str1.drop(i)}"
        }
        return buf
    }

    fun List<Int>.permutation(): List<List<Int>> {
        val buf = mutableListOf<List<Int>>()

        fun generate(n: Int, a: IntArray) {
            if (n == 1) buf += a.toList()
            else {
                for (i in 0 until n) {
                    generate(n - 1, a)
                    if (n % 2 == 0) {
                        val tmp = a[i]
                        a[i] = a[n - 1]
                        a[n - 1] = tmp
                    } else {
                        val tmp = a[0]
                        a[0] = a[n - 1]
                        a[n - 1] = tmp
                    }
                }
            }
        }
        generate(this.size, this.toIntArray())
        return buf
    }
}
