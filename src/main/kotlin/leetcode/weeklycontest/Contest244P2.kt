package leetcode.weeklycontest

object Contest244P2 {
    fun reductionOperations(nums: IntArray): Int {
        val x = nums.groupBy { it }.toSortedMap(Comparator { o1, o2 -> o2 - o1 })
        println(x)
        var sum = 0
        var i = 0
        var size = 0
        x.forEach { (_, lst) ->
            if (i + 1 < x.size) {
                size += lst.size
                sum += size
            }
            i++
        }
        return sum
    }
}
