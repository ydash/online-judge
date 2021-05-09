package leetcode.codingchallenge2021.may

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

object SuperPalindromes {
    fun superpalindromesInRange(left: String, right: String): Int {
        val head = ceil(sqrt(left.toDouble())).toInt()
        val last = floor(sqrt(right.toDouble())).toInt()
        return (head..last).fold(0) { acc, i ->
            val x = i.toLong() * i
            if (isPalindrome(i.toString()) && isPalindrome(x.toString())) {
                acc + 1
            } else acc
        }
    }

    private fun isPalindrome(str: String): Boolean =
        (0..(str.lastIndex) / 2).all { i -> str[i] == str[str.lastIndex - i] }
}
