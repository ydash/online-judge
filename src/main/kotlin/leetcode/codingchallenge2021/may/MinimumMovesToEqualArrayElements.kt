package leetcode.codingchallenge2021.may

import kotlin.math.absoluteValue

object MinimumMovesToEqualArrayElements {
    fun minMoves2(nums: IntArray): Int {
        val goal = nums.sortedArray()[nums.size / 2]

        return nums.sumOf { (goal - it).absoluteValue }
    }
}
