package leetcode.codingchallenge2021.may

import kotlin.math.pow

object SubsetsSolution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val lim = 2.0.pow(nums.size).toInt() - 1
        val answer = mutableListOf<List<Int>>()
        val powOfTwo = generateSequence(1) { it * 2 }.take(nums.size).withIndex()

        (0..lim).forEach { i ->
            val buf = mutableListOf<Int>()
            powOfTwo.forEach { (n, nthBit) ->
                if (nthBit and i != 0) {
                    buf += nums[n]
                }
            }
            answer += buf
        }

        return answer
    }
}
