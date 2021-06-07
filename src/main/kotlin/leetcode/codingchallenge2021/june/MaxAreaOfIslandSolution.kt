package leetcode.codingchallenge2021.june

object MaxAreaOfIslandSolution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var ans = 0
        val m = grid.size
        val n = grid[0].size

        fun dfs(i: Int, j: Int): Int = when (grid.getOrNull(i)?.getOrNull(j)) {
            null, 0 -> 0
            else -> {
                grid[i][j] = 0
                1 + dfs(i + 1, j) + dfs(i - 1, j) + dfs(i, j - 1) + dfs(i, j + 1)
            }
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 1) ans = maxOf(ans, dfs(i, j))
            }
        }

        return ans
    }
}
