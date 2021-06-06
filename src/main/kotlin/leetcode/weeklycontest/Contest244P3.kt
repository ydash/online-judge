package leetcode.weeklycontest

import java.lang.StringBuilder

object Contest244P3 {
    fun minFlips(s: String): Int {
        val ss = "$s$s"
        val (goal1, goal2) = (StringBuilder() to StringBuilder()).let { (sb1, sb2) ->
            (ss.indices).forEach {
                if (it % 2 == 0) {
                    sb1.append('0')
                    sb2.append('1')
                } else {
                    sb1.append('1')
                    sb2.append('0')
                }
            }
            (sb1.toString() to sb2.toString())
        }
        var ans = Int.MAX_VALUE
        var count1 = 0
        var count2 = 0
        (ss.indices).forEach { i ->
            if (ss[i] != goal1[i]) count1 += 1
            if (ss[i] != goal2[i]) count2 += 1
            if (i >= s.length) {
                var j = i - s.length
                if (ss[j] != goal1[j]) count1 -= 1
                if (ss[j] != goal2[j]) count2 -= 1
            }
            if (i >= s.length - 1) ans = minOf(ans, count1, count2)
        }
        return ans
    }
}