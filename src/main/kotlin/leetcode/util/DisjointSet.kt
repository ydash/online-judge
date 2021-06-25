package leetcode.util

class DisjointSet(size: Int) {
    private val rank = IntArray(size + 1)
    private val parent = IntArray(size + 1)

    init {
        (0..size).forEach { i ->
            rank[i] = 0
            parent[i] = i
        }
    }

    fun same(x: Int, y: Int): Boolean = findSet(x) == findSet(y)

    private fun findSet(x: Int): Int {
        if (x != parent[x]) {
            parent[x] = findSet(parent[x])
        }
        return parent[x]
    }

    fun union(x: Int, y: Int) = link(findSet(x), findSet(y))

    private fun link(x: Int, y: Int) = when {
        rank[x] > rank[y] -> parent[y] = x
        rank[x] < rank[y] -> parent[x] = y
        else -> {
            parent[x] = y
            rank[y] += 1
        }
    }
}
