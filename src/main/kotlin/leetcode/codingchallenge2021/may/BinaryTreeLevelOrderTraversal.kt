package leetcode.codingchallenge2021.may

import leetcode.util.TreeNode

object BinaryTreeLevelOrderTraversal {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val acc = mutableListOf<List<Int>>()
        var current = mutableListOf<TreeNode>()

        if (root != null) current.plusAssign(root)

        while (current.isNotEmpty()) {
            val next = mutableListOf<TreeNode>()
            val tmp = mutableListOf<Int>()

            current.forEach {
                tmp += it.`val`
                it.left?.let { l -> next += l }
                it.right?.let { r -> next += r }
            }
            acc += tmp
            current = next
        }

        return acc
    }
}
