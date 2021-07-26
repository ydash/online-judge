package leetcode.codingchallenge2021.july

import leetcode.util.TreeNode

class ConvertSortedArray2BinarySearchTree {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return sortedArrayToBST(nums, 0, nums.lastIndex)
    }

    private fun sortedArrayToBST(nums: IntArray, left: Int, right: Int): TreeNode? = when {
        left > right -> null
        left == right -> TreeNode(nums[left])
        else -> {
            val rootIndex = (left + right) / 2
            val root = TreeNode(nums[rootIndex])
            root.left = sortedArrayToBST(nums, left, rootIndex - 1)
            root.right = sortedArrayToBST(nums, rootIndex + 1, right)
            root
        }
    }
}
