package leetcode.codingchallenge2021.june

import java.util.*

object SwimInRisingWater {
    fun swimInWater(grid: Array<IntArray>): Int {
        val n = grid.size
        val goal = Coordinate(n - 1, n - 1)
        val seen = mutableSetOf<Coordinate>()
        val pq = PriorityQueue<Pair<Int, Coordinate>> { a, b -> a.first - b.first }

        seen += Coordinate(0, 0)
        pq.add(grid[0][0] to Coordinate(0, 0))
        while (pq.isNotEmpty()) {
            val (time, coordinate) = pq.poll()
            if (coordinate == goal) {
                pq.add(time to coordinate)
                break
            }

            val (x, y) = coordinate
            listOf(Coordinate(x - 1, y), Coordinate(x + 1, y), Coordinate(x, y - 1), Coordinate(x, y + 1))
                .filter { (i, j) ->
                    i in 0 until n && j in 0 until n && Coordinate(i, j) !in seen
                }.forEach { (i, j) ->
                    val t = if (grid[i][j] <= time) time else grid[i][j]
                    seen += Coordinate(i, j)
                    pq.add(t to Coordinate(i, j))
                }
        }
        return pq.peek().first
    }

    data class Coordinate(val x: Int, val y: Int)
}