package leetcode.codingchallenge2021.june

object MinimumRefuelingStops {
    fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int =
        when {
            stations.isEmpty() && startFuel < target -> -1
            startFuel >= target -> 0
            else -> {
                val n = stations.size
                val prev = IntArray(n + 1) { startFuel }
                val current = IntArray(n + 1)
                var ans = -1
                loop@ for (i in 1..n) {
                    for (j in i..n) {
                        if (prev[j - 1] >= stations[j - 1][0]) current[j] = prev[j - 1] + stations[j - 1][1]
                        if (current[j] >= target) {
                            ans = i
                            break@loop
                        }
                        current[j] = maxOf(current[j], current[j - 1])
                    }
                    (0..n).forEach {
                        prev[it] = current[it]
                        current[it] = 0
                    }
                }
                ans
            }
        }
}
