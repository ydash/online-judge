package leetcode.codingchallenge2021.may

object FlattenBinaryTreeToLinkedList {
    fun flatten(root: TreeNode?): Unit {
        root?.toLinkedList()
    }

    fun TreeNode.toLinkedList(): TreeNode {
        val tmp = TreeNode(`val`)
        tmp.right = left?.toLinkedList()
        tmp.getMaxNode().right = right?.toLinkedList()
        left = null
        right = tmp.right
        return this
    }

    private fun TreeNode.getMaxNode(): TreeNode = this.right?.getMaxNode() ?: this
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
