package leetcode.codingchallenge2021.june

object StoneGameVIISolution {
    fun stoneGameVII(stones: IntArray): Int {
        val n = stones.size
        val currentDp = IntArray(n)
        val prevDp = IntArray(n)

        (n - 2 downTo 0).forEach { i ->
            var total = stones[i]
            val tmp = prevDp.copyOf()
            (0 until n).forEach { ind -> prevDp[ind] = currentDp[ind] }
            (0 until n).forEach { ind -> currentDp[ind] = tmp[ind] }

            (i + 1 until n).forEach { j ->
                total += stones[j]
                currentDp[j] = maxOf(total - stones[i] - prevDp[j], total - stones[j] - currentDp[j - 1])
            }
        }

        return currentDp.last()
    }
}
