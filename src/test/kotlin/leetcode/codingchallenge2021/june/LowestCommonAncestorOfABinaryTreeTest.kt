package leetcode.codingchallenge2021.june

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import leetcode.util.TreeNode
import java.util.LinkedList

class LowestCommonAncestorOfABinaryTreeTest : StringSpec({
    val root1 = TreeNode(3).apply {
        left = TreeNode(5).apply {
            left = TreeNode(6)
            right = TreeNode(2).apply {
                left = TreeNode(7)
                right = TreeNode(4)
            }
        }
        right = TreeNode(1).apply {
            left = TreeNode(0)
            right = TreeNode(8)
        }
    }
    "given target node, return the path from root to target" {
        forAll(
            row(5, listOf(3 to 0, 5 to 1)),
            row(1, listOf(3 to 0, 1 to 1)),
            row(4, listOf(3 to 0, 5 to 1, 2 to 2, 4 to 3))
        ) { target, expected ->
            LowestCommonAncestorSolution.pathOf(
                root1, 0, target, LinkedList<Pair<Int, Int>>().apply { add(root1.`val` to 0) }
            ) shouldBe expected
        }
    }

    "test of Lowest Common Ancestor" {
        forAll(
            row(TreeNode(5), TreeNode(1), TreeNode(3))
        ) { p, q, expected ->
            LowestCommonAncestorSolution.lowestCommonAncestor(root1, p, q).`val` shouldBe expected.`val`
        }
    }
})
