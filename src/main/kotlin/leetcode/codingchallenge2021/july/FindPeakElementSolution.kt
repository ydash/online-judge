package leetcode.codingchallenge2021.july

class FindPeakElementSolution {
    fun findPeakElement(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1

        while (left < right) {
            val middle = (left + right) / 2

            val up = isUp(nums, middle - 1, middle)
            val down = isDown(nums, middle, middle + 1)

            if (up && down) return middle
            if (up) {
                left = middle + 1
            } else {
                right = middle - 1
            }
        }

        return left
    }

    private fun isDown(nums: IntArray, i: Int, j: Int): Boolean = j == nums.size || nums[i] > nums[j]

    private fun isUp(nums: IntArray, i: Int, j: Int): Boolean = i == -1 || nums[i] < nums[j]
}
