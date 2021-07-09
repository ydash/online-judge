package leetcode.codingchallenge2021.july

class LongestIncreasingSubsequence {
    fun lengthOfLIS(nums: IntArray): Int {
        val subSeq = mutableListOf(nums[0])

        nums.drop(1).forEach { n ->
            if (subSeq.last() < n) subSeq += n
            else subSeq[binarySearch(subSeq, n)] = n
        }

        return subSeq.size
    }

    private fun binarySearch(lst: MutableList<Int>, n: Int): Int {
        var left = 0
        var right = lst.lastIndex

        while (left < right) {
            val mid = (left + right) / 2
            when {
                lst[mid] == n -> return mid
                lst[mid] < n -> left = mid + 1
                else -> right = mid
            }
        }

        return left
    }
}
