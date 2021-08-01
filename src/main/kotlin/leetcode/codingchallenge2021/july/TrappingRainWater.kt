package leetcode.codingchallenge2021.july

class TrappingRainWater {
    fun trap(height: IntArray): Int =
        if (height.isEmpty()) 0 else {
            val n = height.size
            val left = IntArray(n)
            val right = IntArray(n)
            var sum = 0

            left[0] = height[0]
            (1 until n).forEach { i ->
                left[i] = maxOf(left[i - 1], height[i])
            }
            right[n - 1] = height.last()
            (height.lastIndex - 1 downTo 0).forEach { i ->
                right[i] = maxOf(right[i + 1], height[i])
            }

            height.indices.forEach { i ->
                sum += minOf(left[i], right[i]) - height[i]
            }

            sum
        }
}
