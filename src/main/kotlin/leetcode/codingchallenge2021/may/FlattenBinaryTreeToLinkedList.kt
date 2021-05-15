package leetcode.codingchallenge2021.may

object FlattenBinaryTreeToLinkedList {
    fun flatten(root: TreeNode?): Unit {
        root?.run {
            traversePreOrder(this)
        }
    }

    fun traversePreOrder(root: TreeNode): TreeNode {
        if (!root.isLeaf()) {
            val tmp = TreeNode(root.`val`)
            root.left?.run {
                tmp.right = traversePreOrder(this)
            }
            root.right?.run {
                tmp.getMax().right = traversePreOrder(this)
            }
            root.left = tmp.left
            root.right = tmp.right
        }
        return root
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
