package leetcode.codingchallenge2021.june

import leetcode.util.SegmentTree

class NumArray(nums: IntArray) {
    private val segmentTree = SegmentTree(nums)

    fun update(index: Int, `val`: Int) = this.segmentTree.update(index) { `val` }

    fun sumRange(left: Int, right: Int): Int = this.segmentTree.sum(left, right)
}
