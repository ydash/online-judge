package leetcode.codingchallenge2021.july

class NonNegativeIntegersWithoutConsecutiveOnes {
    fun findIntegers(n: Int): Int {
        var x = 1
        var m = 0
        while (x < MAX_NUM) {
            x = x shl 1
            ++m
        }

        val f = IntArray(m + 1)
        f[0] = 1
        f[1] = 2
        (2..m).forEach {
            f[it] = f[it - 1] + f[it - 2]
        }

        var ans = 0
        var prevBit = 0
        for (i in m downTo 0) {
            if (n and (1 shl i) != 0) {
                ans += f[i]
                if (prevBit == 1) {
                    ans--
                    break
                }
                prevBit = 1
            } else {
                prevBit = 0
            }
        }
        return ans + 1
    }

    companion object {
        const val MAX_NUM = 1000000000
    }
}
