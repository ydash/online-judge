package leetcode.codingchallenge2021.may

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import leetcode.util.TreeNode

class BinaryTreeLevelOrderTraversalTest : StringSpec({
    "Given the root of a binary tree, return the level order traversal of its node's values" {
        forAll(
            row(TreeNode(3).also {
                it.left = TreeNode(9)
                it.right = TreeNode(20).also {
                    it.left = TreeNode(15)
                    it.right = TreeNode(7)
                }
            }, listOf(listOf(3), listOf(9, 20), listOf(15, 7))),
            row(TreeNode(1), listOf(listOf(1))),
            row(null, listOf())
        ) { root, expected ->
            BinaryTreeLevelOrderTraversal.levelOrder(root) shouldBe expected
        }
    }
})
