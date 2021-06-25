package leetcode.codingchallenge2021.june

object RedundantConnection {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val connected = Array(1001) { mutableSetOf(it) }
        var ans = intArrayOf()

        edges.forEach { (n1, n2) ->
            if (connected[n1].contains(n2)) ans = intArrayOf(n1, n2)
            val c = connected[n1] + connected[n2]
            c.forEach { connected[it] += c }
        }

        return ans
    }
}