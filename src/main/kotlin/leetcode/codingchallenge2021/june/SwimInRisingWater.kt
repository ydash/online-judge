package leetcode.codingchallenge2021.june

import java.util.*

object SwimInRisingWater {
    fun swimInWater(grid: Array<IntArray>): Int {
        val n = grid.size
        val goal = Coordinate(n - 1, n - 1)
        val seen = Array(n) { BooleanArray(n) }
        val pq = PriorityQueue<Pair<Int, Coordinate>> { a, b -> a.first - b.first }

        seen[0][0] = true
        pq.add(grid[0][0] to Coordinate(0, 0))
        while (pq.isNotEmpty()) {
            val (time, coordinate) = pq.peek()
            if (coordinate == goal) break

            val (x, y) = pq.poll().second
            listOf(Coordinate(x - 1, y), Coordinate(x + 1, y), Coordinate(x, y - 1), Coordinate(x, y + 1))
                .filter { (i, j) ->
                    i in 0 until n && j in 0 until n && !seen[i][j]
                }.forEach { (i, j) ->
                    val t = if (grid[i][j] <= time) time else grid[i][j]
                    seen[i][j] = true
                    pq.add(t to Coordinate(i, j))
                }
        }
        return pq.peek().first
    }

    data class Coordinate(val x: Int, val y: Int)
}