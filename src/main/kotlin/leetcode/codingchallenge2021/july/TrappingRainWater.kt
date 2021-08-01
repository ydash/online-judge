package leetcode.codingchallenge2021.july

class TrappingRainWater {
    fun trap(height: IntArray): Int {
        if (height.isEmpty()) return 0

        val n = height.size
        var left = 0
        var right = n - 1
        var leftMax = height[left]
        var rightMax = height[right]
        var sum = 0

        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) leftMax = height[left]
                else sum += leftMax - height[left]
                left++
            } else {
                if (height[right] >= rightMax) rightMax = height[right]
                else sum += rightMax - height[right]
                right--
            }
        }

        return sum
    }
}
