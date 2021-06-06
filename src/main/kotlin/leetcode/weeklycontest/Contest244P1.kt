package leetcode.weeklycontest

object Contest244P1 {
    fun findRotation(mat: Array<IntArray>, target: Array<IntArray>): Boolean {
        val r1 = mat.rotateRight()
        val r2 = r1.rotateRight()
        val r3 = r2.rotateRight()

        return equal(target, mat) || equal(target, r1) || equal(target, r2) || equal(target, r3)
    }

    fun Array<IntArray>.rotateRight(): Array<IntArray> =
        Array(size) { i -> IntArray(this[0].size) { j -> this[size - j - 1][i] } }

    fun equal(a1: Array<IntArray>, a2: Array<IntArray>): Boolean =
        a1.indices.all { i -> a1[0].indices.all { j -> a1[i][j] == a2[i][j] } }

}
