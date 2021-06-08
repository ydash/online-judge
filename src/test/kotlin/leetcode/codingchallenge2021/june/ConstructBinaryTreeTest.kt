package leetcode.codingchallenge2021.june

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class ConstructBinaryTreeTest : StringSpec({
    "given preorder traversal of a binary tree and inorder traversal of the same tree, construct and return the binary tree" {
        forAll(
            row(intArrayOf(1), intArrayOf(1), "1"),
            row(intArrayOf(1, 2, 3), intArrayOf(2, 1, 3), "2, 3, 1"),
            row(intArrayOf(3, 9, 20, 15, 7), intArrayOf(9, 3, 15, 20, 7), "9, 15, 7, 20, 3"),
            row(intArrayOf(1, 2, 3, 4, 5), intArrayOf(5, 4, 3, 2, 1), "5, 4, 3, 2, 1"),
            row(intArrayOf(1, 2, 3, 4, 5), intArrayOf(1, 2, 3, 4, 5), "5, 4, 3, 2, 1"),
            row(
                intArrayOf(1, 2, 4, 8, 9, 5, 10, 3, 6, 7, 11),
                intArrayOf(8, 4, 9, 2, 5, 10, 1, 6, 3, 11, 7),
                "8, 9, 4, 10, 5, 2, 6, 11, 7, 3, 1"
            ),
            row(IntArray(3000) { it }, IntArray(3000) { it }, (2999 downTo 0).joinToString(", "))
        ) { preorder, inorder, expected ->
            ConstructBinaryTree.buildTree(preorder, inorder).toPostOrderStr() shouldBe expected
        }
    }
})
