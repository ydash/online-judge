package leetcode.codingchallenge2021.june

import leetcode.util.DisjointSet

object RedundantConnection {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val disjointSet = DisjointSet(1001)
        var ans = intArrayOf()

        edges.forEach { (n1, n2) ->
            if (disjointSet.same(n1, n2)) ans = intArrayOf(n1, n2)
            else disjointSet.union(n1, n2)
        }

        return ans
    }
}
