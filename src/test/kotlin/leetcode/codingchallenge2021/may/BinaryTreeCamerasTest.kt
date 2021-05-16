package leetcode.codingchallenge2021.may

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class BinaryTreeCamerasTest : StringSpec({
    "Calculate the minimum number of cameras needed to monitor all nodes of the tree." {
        val tree1 = TreeNode(0).also { root ->
            root.left = TreeNode(0).also {
                it.left = TreeNode(0)
                it.right = TreeNode(0)
            }
        }
        val tree2 = TreeNode(0).also {
            it.left = TreeNode(0).also {
                it.left = TreeNode(0).also { it.left = TreeNode(0).also { it.right = TreeNode(0) } }
            }
        }

        val tree3 = TreeNode(0)

        val tree4 = TreeNode(0).also {
            it.left = TreeNode(0).also {
                it.left = TreeNode(0)
                it.right = TreeNode(0)
            }
            it.right = TreeNode(0).also {
                it.left = TreeNode(0)
                it.right = TreeNode(0)
            }
        }

        forAll(
            row(tree1, 1),
            row(tree2, 2),
            row(tree3, 1),
            row(tree4, 2)
        ) { input, output ->
            BinaryTreeCameras.minCameraCover(input) shouldBe output
        }
    }
})
