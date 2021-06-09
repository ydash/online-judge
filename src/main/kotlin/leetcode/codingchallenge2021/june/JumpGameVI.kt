package leetcode.codingchallenge2021.june

import java.util.*

object JumpGameVI {
    fun maxResult(nums: IntArray, k: Int): Int {
        val deque = ArrayDeque<IndexedScore>()
        deque.addFirst(IndexedScore(nums.lastIndex, nums.last()))

        (nums.lastIndex - 1 downTo 0).forEach { i ->
            while (deque.isNotEmpty() && deque.first.index > i + k) deque.removeFirst()
            val score = nums[i] + deque.first.score
            while (deque.isNotEmpty() && deque.last.score < score) deque.removeLast()
            deque.addLast(IndexedScore(i, score))
        }
        return deque.last.score
    }

    data class IndexedScore(val index: Int, val score: Int)
}