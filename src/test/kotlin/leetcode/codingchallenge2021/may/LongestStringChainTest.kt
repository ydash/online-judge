package leetcode.codingchallenge2021.may

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LongestStringChainTest : StringSpec({
    "Return the longest possible length of a word chain with words chosen from the given list of words." {
        forAll(
            row(arrayOf("a"), 1),
            row(arrayOf("a", "ab"), 2),
            row(arrayOf("a", "b", "ba"), 2),
            row(arrayOf("a", "b", "ba", "bca", "bda", "bdca"), 4),
            row(arrayOf("xbc", "pcxbcf", "xb", "cxbc", "pcxbc"), 5)
        ) { input, output ->
            LongestStringChain().longestStrChain(input) shouldBe output
        }
    }

    "given two strings, return true if one is a predecessor of the other" {
        forAll(
            row("bda", "bdca", true),
            row("a", "ab", true),
            row("a", "b", false),
            row("bda", "bdca", true),
            row("abb", "ad", false),
            row("abc", "bdef", false),
            row("abc", "abc", false)
        ) { word1, word2, expected ->
            LongestStringChain().canChain(word1, word2) shouldBe expected
        }
    }
})
