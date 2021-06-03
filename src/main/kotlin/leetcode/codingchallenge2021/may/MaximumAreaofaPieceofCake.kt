package leetcode.codingchallenge2021.may

const val DIVISOR = 1000000007

object MaximumAreaofaPieceofCake {
    fun maxArea(h: Int, w: Int, horizontalCuts: IntArray, verticalCuts: IntArray): Int {
        horizontalCuts.sort()
        verticalCuts.sort()
        var maxH = 0
        var maxW = 0

        maxH = maxOf(maxH, horizontalCuts[0])
        maxH = maxOf(maxH, h - horizontalCuts.last())
        horizontalCuts.indices.drop(1).forEach { i ->
            maxH = maxOf(maxH, horizontalCuts[i] - horizontalCuts[i - 1])
        }

        maxW = maxOf(maxW, verticalCuts[0])
        maxW = maxOf(maxW, w - verticalCuts.last())
        verticalCuts.indices.drop(1).forEach { i ->
            maxW = maxOf(maxW, verticalCuts[i] - verticalCuts[i - 1])
        }

        return ((maxH.toLong() * maxW) % DIVISOR).toInt()
    }
}
