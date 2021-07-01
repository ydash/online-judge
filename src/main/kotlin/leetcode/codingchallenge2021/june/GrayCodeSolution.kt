package leetcode.codingchallenge2021.june

import kotlin.math.pow

object GrayCodeSolution {
    fun grayCode(n: Int): List<Int> = (0 until 2.0.pow(n.toDouble()).toInt()).map { x -> x xor (x shr 1) }
}
