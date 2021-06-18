package leetcode.codingchallenge2021.june

object NumberOfSubArraysWithBoundedMaximum {
    fun numSubarrayBoundedMax(nums: IntArray, left: Int, right: Int): Int {
        var include = 0
        var exclude = 0
        var ans = 0
        nums.forEach { n ->
            when {
                n < left -> {
                    ++include
                    ++exclude
                }
                n > right -> {
                    ans += count(include) - count(exclude)
                    include = 0
                    exclude = 0
                }
                else -> {
                    ans -= count(exclude)
                    exclude = 0
                    ++include
                }
            }
        }
        ans += count(include) - count(exclude)
        return ans
    }

    private fun count(n: Int) = n * (n + 1) / 2
}
