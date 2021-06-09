package leetcode.codingchallenge2021.june

import java.util.*

object JumpGameVI {
    fun maxResult(nums: IntArray, k: Int): Int {
        val pq = PriorityQueue(Comparator<IndexedScore> { a, b -> b.score - a.score })
        pq.add(IndexedScore(0, nums[0]))

        (1 until nums.size).forEach { i ->
            while (pq.peek().index < i - k) pq.poll()
            pq.add(IndexedScore(i, nums[i] + pq.peek().score))
        }

        return pq.find { it.index == nums.lastIndex }!!.score
    }

    data class IndexedScore(val index: Int, val score: Int)
}