package leetcode.codingchallenge2021.june

object LongestConsecutiveSequence {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toSet()
        var ans = 0
        nums.forEach {
            if (!set.contains(it - 1)) {
                var count = 1
                var current = it + 1
                while (set.contains(current++)) ++count
                ans = maxOf(ans, count)
            }
        }
        return ans
    }
}
