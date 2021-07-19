package leetcode.codingchallenge2021.july

import leetcode.util.TreeNode

class LowestCommonAncestorOfABinarySearchTree {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        var current = root
        val (left, right) = Pair(p!!.`val`, q!!.`val`).let { (f, s) -> if (f > s) s to f else f to s }

        loop@ while (current != null) {
            val v = current.`val`
            when {
                v in left..right -> break@loop
                v < left -> current = current.right
                right < v -> current = current.left
            }
        }

        return current
    }
}
