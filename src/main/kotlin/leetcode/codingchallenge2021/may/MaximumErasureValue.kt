package leetcode.codingchallenge2021.may

import kotlin.math.max

object MaximumErasureValue {
    fun maximumUniqueSubarray(nums: IntArray): Int {
        val cache = mutableMapOf<Int, Int>()
        var acc1 = 0
        var acc2 = 0

        var left = 0
        var right = 0
        while (right < nums.size) {
            val n = nums[right]
            val i = cache[n]
            when {
                i == null || i < left -> {
                    cache[n] = right
                    acc1 += n
                    right++
                }
                else -> {
                    if (acc1 > acc2) acc2 = acc1
                    acc1 -= (left..i).sumOf { nums[it] }
                    left = i + 1
                }
            }
        }

        return max(acc2, acc1)
    }
}
