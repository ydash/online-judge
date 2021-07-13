package leetcode.codingchallenge2021.july

class FindPeakElementSolution {
    fun findPeakElement(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1

        while (left < right) {
            val middle = (left + right) / 2

            if (nums[middle] > nums[middle + 1]) right = middle
            else left = middle + 1
        }

        return left
    }
}
