package leetcode.codingchallenge2021.june

object MaxConsecutiveOnesIII {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var i = 0
        var zeroCount = 0
        var ans = 0

        nums.indices.forEach { j ->
            if (nums[j] == 0) {
                if (zeroCount < k) ++zeroCount
                else while (true) {
                    if (nums[i++] == 0) break
                }
            }

            ans = maxOf(ans, j - i + 1)
        }

        return ans
    }
}
