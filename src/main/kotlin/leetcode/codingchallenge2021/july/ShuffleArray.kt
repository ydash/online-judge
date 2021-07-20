package leetcode.codingchallenge2021.july

import kotlin.random.Random

class ShuffleArray(nums: IntArray) {
    private val original = nums

    fun reset(): IntArray = original

    fun shuffle(): IntArray {
        val tmp = original.copyOf()
        for (i in tmp.lastIndex downTo 1) {
            val j = Random.nextInt(i + 1)
            val copy = tmp[i]
            tmp[i] = tmp[j]
            tmp[j] = copy
        }
        return tmp
    }
}
