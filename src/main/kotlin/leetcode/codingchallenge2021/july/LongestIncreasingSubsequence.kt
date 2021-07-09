package leetcode.codingchallenge2021.july

import java.util.TreeMap
import java.util.TreeSet

class LongestIncreasingSubsequence {
    fun lengthOfLIS(nums: IntArray): Int {
        val cache = TreeMap<Int, TreeSet<Int>> { a, b -> b - a }

        nums.indices.reversed().forEach { i ->
            val n = nums[i]
            var count = 1
            for ((c, set) in cache) {
                if (set.ceiling(n + 1) != null) {
                    count = c + 1
                    break
                }
            }
            when (val set = cache[count]) {
                null -> cache += count to sortedSetOf(n)
                else -> set += n
            }
        }

        return cache.firstKey()
    }
}
