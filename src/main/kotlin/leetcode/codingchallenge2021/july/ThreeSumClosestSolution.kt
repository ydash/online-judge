package leetcode.codingchallenge2021.july

import kotlin.math.absoluteValue

class ThreeSumClosestSolution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var minDiff = Int.MAX_VALUE

        for (i in 0 until nums.size - 2) {
            for (j in i + 1 until nums.size - 1) {
                val x = target - (nums[i] + nums[j])
                val diff = binarySearch(nums, x, j + 1, nums.lastIndex)
                minDiff = if (diff.absoluteValue < minDiff.absoluteValue) diff else minDiff
                if (minDiff == 0) break
            }
        }

        return target - minDiff
    }

    private fun binarySearch(nums: IntArray, target: Int, start: Int, last: Int): Int {
        var left = start
        var right = last
        var minDiff = Int.MAX_VALUE

        loop@ while (left <= right) {
            val mid = (left + right) / 2
            val diff = target - nums[mid]
            minDiff = if (diff.absoluteValue < minDiff.absoluteValue) diff else minDiff
            when {
                diff == 0 -> break@loop
                diff < 0 -> right = mid - 1
                else -> left = mid + 1
            }
        }

        return minDiff
    }
}
