package leetcode.codingchallenge2021.june

object MinCostClimbingStairsSolution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        tailrec fun loop(a: Int, b: Int, i: Int): Int =
            if (i > cost.size) b
            else loop(b, minOf(a + cost[i - 2], b + cost[i - 1]), i + 1)

        return loop(0, 0, 2)
    }
}
