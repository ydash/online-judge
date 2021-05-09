package leetcode.codingchallenge2021.may

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

object SuperPalindromes {
    fun superpalindromesInRange(left: String, right: String): Int {
        val head = ceil(sqrt(left.toDouble())).toInt()
        val last = floor(sqrt(right.toDouble())).toInt()
        var i = head
        var count = 0
        while (i <= last) {
            if (isPalindrome(i.toString()) && isPalindrome((i.toLong() * i).toString())) count += 1
            i++
        }
        return count
    }

    private fun isPalindrome(str: String): Boolean =
        (0..(str.lastIndex) / 2).all { i -> str[i] == str[str.lastIndex - i] }
}
