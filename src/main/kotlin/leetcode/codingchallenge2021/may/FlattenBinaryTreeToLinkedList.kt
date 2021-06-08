package leetcode.codingchallenge2021.may

import leetcode.util.TreeNode

object FlattenBinaryTreeToLinkedList {
    fun flatten(root: TreeNode?) {
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
