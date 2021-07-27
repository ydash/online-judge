package leetcode.codingchallenge2021.july

import kotlin.math.absoluteValue

class ThreeSumClosestSolution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var minDiff = Int.MAX_VALUE

        for (i in nums.indices) {
            var left = i + 1
            var right = nums.lastIndex
            while (left < right) {
                val diff = target - (nums[i] + nums[left] + nums[right])
                minDiff = if (diff.absoluteValue < minDiff.absoluteValue) diff else minDiff
                if (minDiff == 0) break
                if (diff > 0) ++left else --right
            }
        }

        return target - minDiff
    }
}
