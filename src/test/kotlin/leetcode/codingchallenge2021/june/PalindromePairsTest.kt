package leetcode.codingchallenge2021.june

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import leetcode.codingchallenge2021.june.PalindromePairs.isPalindrome

class PalindromePairsTest : StringSpec({
    "test of palindrome pairs" {
        forAll(
            row(arrayOf("abcd", "dcba", "lls", "s", "sssll"),
                listOf(listOf(0, 1), listOf(1, 0), listOf(3, 2), listOf(2, 4))),
            row(arrayOf("bat", "tab", "cat"), listOf(listOf(0, 1), listOf(1, 0))),
            row(arrayOf("a", ""), listOf(listOf(0, 1), listOf(1, 0)))
        ) { input, output ->
            PalindromePairs.palindromePairs(input) shouldBe output
        }
    }

    "return true if the string is palindrome." {
        forAll(
            row("abcdcba", true),
            row("abcda", false),
            row("a", true)
        ) { str, expected ->
            str.isPalindrome() shouldBe expected
        }
    }
})
