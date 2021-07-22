package leetcode.codingchallenge2021.july

class PartitionArrayIntoDisjointIntervals {
    fun partitionDisjoint(nums: IntArray): Int {
        val rMin = IntArray(nums.size)
        rMin[rMin.lastIndex] = nums.last()
        for (i in nums.lastIndex - 1 downTo 0) {
            rMin[i] = minOf(rMin[i + 1], nums[i])
        }

        var lMax = nums[0]
        for (p in 1..nums.lastIndex) {
            if (lMax <= rMin[p]) return p
            lMax = maxOf(lMax, nums[p])
        }

        throw IllegalArgumentException("argument `nums` is illegal.")
    }
}
