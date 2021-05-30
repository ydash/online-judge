package leetcode.weeklycontest

import java.util.*

object Contest243P3 {
    fun assignTasks(servers: IntArray, tasks: IntArray): IntArray {
        val ans = IntArray(tasks.size)
        val serverQueue =
            PriorityQueue(kotlin.Comparator<Int> { a, b -> if (servers[a] == servers[b]) a - b else servers[a] - servers[b] }).apply {
                servers.indices.forEach(this::add)
            }
        val inUse = PriorityQueue(compareBy<Pair<Int, Int>> { it.second })

        var currentTime = 0
        for (i in tasks.indices) {
            currentTime = maxOf(i, currentTime)

            if (serverQueue.isEmpty()) {
                val (serverInd, t) = inUse.poll()
                serverQueue.add(serverInd)
                currentTime = t
            }
            while (inUse.isNotEmpty() && inUse.peek().second <= currentTime) serverQueue.add(inUse.poll().first)

            val serverInd = serverQueue.poll()
            inUse.add(Pair(serverInd, currentTime + tasks[i]))
            ans[i] = serverInd
        }

        return ans
    }
}