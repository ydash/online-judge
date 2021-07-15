package leetcode.codingchallenge2021.july

class ValidTriangleNumber {
    fun triangleNumber(nums: IntArray): Int {
        nums.sort()
        var count = 0

        (0..nums.lastIndex - 2).forEach { i ->
            var k = i + 2
            (i + 1 until nums.lastIndex).forEach { j ->
                while (k < nums.size && nums[i] + nums[j] > nums[k]) ++k
                if (k > j) count += k - j - 1
            }
        }

        return count
    }
}
