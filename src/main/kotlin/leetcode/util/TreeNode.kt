package leetcode.codingchallenge2021.may

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        val leftStr = this.left.toString()
        val rightStr = this.right.toString()
        return "${`val`},$leftStr,$rightStr"
    }
}
