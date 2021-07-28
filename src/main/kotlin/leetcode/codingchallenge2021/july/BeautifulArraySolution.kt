package leetcode.codingchallenge2021.july

class BeautifulArraySolution {
    fun beautifulArray(n: Int): IntArray = makeBeautifulArray(n, arrayListOf(1))

    private tailrec fun makeBeautifulArray(n: Int, arr: ArrayList<Int>): IntArray =
        if (arr.size >= n) arr.toIntArray()
        else {
            val tmp = arrayListOf<Int>()
            arr.indices.forEach { i ->
                if (arr[i] * 2 - 1 <= n) tmp += arr[i] * 2 - 1
            }
            arr.indices.forEach { i ->
                if (arr[i] * 2 <= n) tmp += arr[i] * 2
            }
            makeBeautifulArray(n, tmp)
        }
}
