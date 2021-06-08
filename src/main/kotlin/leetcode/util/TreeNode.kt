package leetcode.util

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        val leftStr = this.left.toString()
        val rightStr = this.right.toString()
        return "${`val`},$leftStr,$rightStr"
    }

    fun toPostOrderStr(): String {
        val leftStr = this.left?.toPostOrderStr()
        val rightStr = this.right?.toPostOrderStr()
        return "${if (leftStr != null) "$leftStr, " else ""}${if (rightStr != null) "$rightStr, " else ""}${`val`}"
    }
}
