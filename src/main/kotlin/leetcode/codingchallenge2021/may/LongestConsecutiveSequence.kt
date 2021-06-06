package leetcode.codingchallenge2021.may

object LongestConsecutiveSequence {
    fun longestConsecutive(nums: IntArray): Int {
        var ans = 0
        val set = nums.toSet()
        nums.forEach {
            if (set.contains(it) && !set.contains(it - 1)) {
                var count = 1
                var current = it + 1
                loop@ while (true) {
                    if (!set.contains(current)) break@loop
                    ++current
                    ++count
                }
                ans = maxOf(ans, count)
            }
        }
        return ans
    }
}