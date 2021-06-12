package leetcode.codingchallenge2021.june

import java.util.*

object MinimumRefuelingStops {
    fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
        val n = stations.size
        val pq = PriorityQueue<Int> { a, b -> b - a }
        var count = 0
        var current = startFuel
        var i = 0
        while (current < target) {
            while (i < n && stations[i][0] <= current) pq.offer(stations[i++][1])
            if (pq.isEmpty()) {
                count = -1
                break
            }
            current += pq.poll()
            ++count
        }
        return count
    }
}
