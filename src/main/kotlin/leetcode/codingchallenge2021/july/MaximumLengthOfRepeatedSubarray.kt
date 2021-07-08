package leetcode.codingchallenge2021.july

class MaximumLengthOfRepeatedSubarray {
    fun findLength(nums1: IntArray, nums2: IntArray): Int {
        val dp = Array(nums1.size + 1) { IntArray(nums2.size + 1) }
        var max = 0

        (nums1.size - 1 downTo 0).forEach { i ->
            nums2.indices.forEach { j ->
                dp[i][j] = if (nums1[i] == nums2[j]) dp[i + 1][j + 1] + 1 else 0
                max = maxOf(dp[i][j], max)
            }
        }

        return max
    }
}
