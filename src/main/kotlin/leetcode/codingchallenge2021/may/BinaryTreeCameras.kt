package leetcode.codingchallenge2021.may

object BinaryTreeCameras {
    fun minCameraCover(root: TreeNode?): Int =
        setUpCamera(root).let { if (it is Status.UNMONITORED) it.count + 1 else it.count }

    private fun setUpCamera(tree: TreeNode?): Status = when (tree) {
        null -> Status.MONITORED(0)
        else -> {
            val lStatus = setUpCamera(tree.left)
            val rStatus = setUpCamera(tree.right)
            val count = lStatus.count + rStatus.count
            when {
                lStatus is Status.UNMONITORED || rStatus is Status.UNMONITORED ->
                    Status.CAMERA(count + 1)
                lStatus is Status.CAMERA || rStatus is Status.CAMERA ->
                    Status.MONITORED(count)
                else ->
                    Status.UNMONITORED(count)
            }
        }
    }

    sealed class Status(open val count: Int) {
        data class CAMERA(override val count: Int) : Status(count)
        data class MONITORED(override val count: Int) : Status(count)
        data class UNMONITORED(override val count: Int) : Status(count)
    }

}
