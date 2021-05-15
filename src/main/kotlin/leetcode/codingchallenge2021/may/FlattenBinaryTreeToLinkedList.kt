package leetcode.codingchallenge2021.may

object FlattenBinaryTreeToLinkedList {
    fun flatten(root: TreeNode?): Unit {
        root?.run {
            this.toLinkedList()
        }
    }

    fun TreeNode.toLinkedList(): TreeNode {
        if (!isLeaf()) {
            val tmp = TreeNode(`val`)
            left?.run {
                tmp.right = this.toLinkedList()
            }
            right?.run {
                tmp.getMax().right = this.toLinkedList()
            }
            left = tmp.left
            right = tmp.right
        }
        return this
    }

    private fun TreeNode.isLeaf(): Boolean = this.left == null && this.right == null
    private fun TreeNode.getMax(): TreeNode = this.right?.getMax() ?: this
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        val leftStr = this.left.toString() ?: "null"
        val rightStr = this.right.toString() ?: "null"
        return "${`val`},$leftStr,$rightStr"
    }
}
