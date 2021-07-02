package leetcode.codingchallenge2021.july

import java.util.*
import kotlin.math.abs

object FindKClosestElements {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        val ans = LinkedList<Int>()

        for (b in arr) {
            ans += if (ans.size < k) b
            else {
                val a = ans.first
                if (lessThan(x, a, b)) {
                    break
                } else {
                    ans.removeFirst()
                    b
                }
            }
        }

        return ans
    }

    private fun lessThan(x: Int, a: Int, b: Int): Boolean {
        val d1 = abs(x - a)
        val d2 = abs(x - b)

        return d1 < d2 || (d1 == d2 && a < b)
    }
}
