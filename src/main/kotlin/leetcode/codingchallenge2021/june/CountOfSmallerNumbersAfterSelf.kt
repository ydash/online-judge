package leetcode.codingchallenge2021.june

import leetcode.util.SegmentTree
import java.util.*

object CountOfSmallerNumbersAfterSelf {
    fun countSmaller(nums: IntArray): List<Int> {
        val x = 10000
        val segmentTree = SegmentTree(IntArray(200001))
        val answer = LinkedList<Int>()

        (nums.lastIndex downTo 0).forEach {
            val i = nums[it]
            answer.addFirst(segmentTree.sum(0, i + x - 1))
            segmentTree.update(i + x) { n -> n + 1 }
        }

        return answer
    }
}