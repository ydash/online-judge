package leetcode.codingchallenge2021.july

import leetcode.util.TreeNode

class BinaryTreePruning {
    fun pruneTree(root: TreeNode?): TreeNode? = root!!.pruning()

    private fun TreeNode.pruning(): TreeNode? {
        this.left = this.left?.pruning()
        this.right = this.right?.pruning()

        return when {
            this.left == null && this.right == null && this.`val` == 0 -> null
            else -> this
        }
    }
}
