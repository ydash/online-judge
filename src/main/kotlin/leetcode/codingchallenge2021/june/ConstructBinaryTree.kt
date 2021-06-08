package leetcode.codingchallenge2021.june

import leetcode.util.TreeNode

object ConstructBinaryTree {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode {
        val n = preorder.size

        fun loop(pl: Int, il: Int, ir: Int): TreeNode {
            val value = preorder[pl]
            val current = TreeNode(value)
            val pivot = (il..ir).first { inorder[it] == value }
            val lSize = pivot - il
            if (il < pivot) current.left = loop(pl + 1, il, il + lSize - 1)
            if (pivot < ir) current.right = loop(pl + lSize + 1, pivot + 1, ir)
            return current
        }

        return loop(0, 0, n - 1)
    }
}
