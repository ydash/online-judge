package leetcode.codingchallenge2021.may

import kotlin.math.floor
import kotlin.math.sqrt

object SuperPalindromes {
    fun superpalindromesInRange(left: String, right: String): Int {
        val lowerBound = left.toLong()
        val lim = floor(sqrt(right.toDouble())).toLong()

        return odd(lowerBound = lowerBound, lim = lim) +
                even(lowerBound = lowerBound, lim = lim)
    }

    private tailrec fun odd(current: Int = 1, lowerBound: Long, lim: Long, count: Int = 0): Int {
        val p = current.toString().let { it + it.reversed().drop(1) }.toLong()
        return if (p > lim) count
        else {
            val x = p * p
            odd(
                current + 1,
                lowerBound,
                lim,
                if (x >= lowerBound && isPalindrome(x.toString())) count + 1
                else count
            )
        }
    }

    private tailrec fun even(current: Int = 0, lowerBound: Long, lim: Long, count: Int = 0): Int {
        val p = current.toString().let { it + it.reversed() }.toLong()
        return if (p > lim) count
        else {
            val x = p * p
            even(
                current + 1,
                lowerBound,
                lim,
                if (x >= lowerBound && isPalindrome(x.toString())) count + 1
                else count
            )
        }
    }

    private fun isPalindrome(str: String): Boolean =
        (0..(str.lastIndex) / 2).all { i -> str[i] == str[str.lastIndex - i] }
}
