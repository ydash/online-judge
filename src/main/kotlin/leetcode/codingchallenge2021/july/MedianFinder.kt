package leetcode.codingchallenge2021.july

class MedianFinder {
    private val lst = ArrayList<Int>()
    fun addNum(num: Int) {
        val i = lst.binarySearch(num).let { if (it < 0) -(it + 1) else it }
        lst.add(i, num)
    }

    fun findMedian(): Double {
        val len = lst.size
        val i = len / 2
        return if (len % 2 == 0) (lst[i] + lst[i - 1]) / 2.0
        else lst[i].toDouble()
    }
}
