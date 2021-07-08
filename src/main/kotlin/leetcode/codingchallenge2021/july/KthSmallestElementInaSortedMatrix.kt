package leetcode.codingchallenge2021.july

import java.util.PriorityQueue

class KthSmallestElementInaSortedMatrix {
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val pq = PriorityQueue<Index> { a, b -> matrix[a.i][a.j] - matrix[b.i][b.j] }
        val n = matrix[0].size
        matrix.indices.forEach { i -> pq += Index(i, j = 0) }

        repeat(k - 1) {
            val (x, y) = pq.poll()
            if (y < n - 1) pq += Index(x, y + 1)
        }

        return pq.peek().let { (i, j) -> matrix[i][j] }
    }

    data class Index(val i: Int, val j: Int)
}
