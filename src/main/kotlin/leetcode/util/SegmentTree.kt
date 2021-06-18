package leetcode.util

interface SegmentTree {
    val left: Int
    val right: Int
    var value: Int

    fun update(i: Int, newValue: Int): Int

    fun sum(left: Int, right: Int): Int

    data class Node(
        override val left: Int,
        override val right: Int,
        override var value: Int,
        private val leftNode: SegmentTree,
        private val rightNode: SegmentTree,
    ) : SegmentTree {
        override fun update(i: Int, newValue: Int): Int {
            val diff =
                if (leftNode.left <= i && i <= leftNode.right) leftNode.update(i, newValue)
                else rightNode.update(i, newValue)
            this.value += diff
            return diff
        }

        override fun sum(left: Int, right: Int): Int = when {
            right < this.left || this.right < left -> 0
            left <= this.left && this.right <= right -> this.value
            else -> this.leftNode.sum(left, right) + this.rightNode.sum(left, right)
        }
    }

    data class Leaf(override val left: Int, override val right: Int, override var value: Int) : SegmentTree {
        override fun update(i: Int, newValue: Int): Int {
            val diff = newValue - this.value
            this.value = newValue
            return diff
        }

        override fun sum(left: Int, right: Int): Int = if (left <= this.left && this.right <= right) this.value else 0
    }

    companion object {
        operator fun invoke(array: IntArray): SegmentTree = invokeAux(array, 0, array.size - 1)

        private fun invokeAux(array: IntArray, left: Int, right: Int): SegmentTree =
            if (left == right) Leaf(left, right, array[left])
            else Node(
                left,
                right,
                (left..right).sumOf { array[it] },
                invokeAux(array, left, (left + right) / 2),
                invokeAux(array, ((left + right) / 2) + 1, right)
            )
    }
}