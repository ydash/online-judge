package leetcode.codingchallenge2021.july

class FourSumSolution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort()
        for (i in nums.indices) {
            if (i != 0 && nums[i] == nums[i - 1]) continue
            for (j in i + 1 until nums.size) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue
                val t = target - nums[i] - nums[j]
                var left = j + 1
                var right = nums.size - 1
                while (left < right) {
                    when {
                        nums[left] + nums[right] == t -> {
                            result.add(listOf(nums[i], nums[j], nums[left], nums[right]))
                            left++
                            right--
                            while (left < nums.size && nums[left] == nums[left - 1]) left++
                            while (right >= 0 && nums[right] == nums[right + 1]) right--
                        }
                        nums[left] + nums[right] < t -> left++
                        else -> right--
                    }
                }
            }
        }
        return result
    }
}
