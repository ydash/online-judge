package leetcode.codingchallenge2021.july

class BeautifulArraySolution {
    fun beautifulArray(n: Int): IntArray = makeBeautifulArray(n, listOf(1))

    private tailrec fun makeBeautifulArray(n: Int, arr: List<Int>): IntArray =
        if (arr.size >= n) arr.toIntArray()
        else {
            val tmp = mutableListOf<Int>()
            arr.forEach {
                if (it * 2 - 1 <= n) tmp += it * 2 - 1
            }
            arr.forEach {
                if (it * 2 <= n) tmp += it * 2
            }
            makeBeautifulArray(n, tmp)
        }
}
