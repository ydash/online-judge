package leetcode.codingchallenge2021.may

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import leetcode.codingchallenge2021.may.FlattenBinaryTreeToLinkedList.toLinkedList
import leetcode.util.TreeNode

class FlattenBinaryTreeToLinkedListTest : StringSpec({
    val one = TreeNode(1)
    val two = TreeNode(2)
    val three = TreeNode(3)
    val four = TreeNode(4)
    val five = TreeNode(5)
    val six = TreeNode(6)

    "Given the root of a binary tree, flatten the tree into a \"linked list\"" {
        val root = one.also { root ->
            root.left = two.also {
                it.left = three
                it.right = four
            }
            root.right = five.also {
                it.right = six
            }
        }

        val actual = root.toLinkedList().toString()

        actual shouldBe "1,null,2,null,3,null,4,null,5,null,6,null,null"
    }
})
