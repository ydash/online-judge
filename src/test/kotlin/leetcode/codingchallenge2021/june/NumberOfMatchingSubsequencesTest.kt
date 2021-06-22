package leetcode.codingchallenge2021.june

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class NumberOfMatchingSubsequencesTest : StringSpec({
    "Given string s and an array of strings words, return the number of word that is a subsequence of s" {
        forAll(
            row("abcde", arrayOf("a", "bb", "acd", "ace"), 3),
            row("dsahjpjauf", arrayOf("ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"), 2)
        ) { s, words, expected ->
            NumberOfMatchingSubsequences.numMatchingSubseq(s, words) shouldBe expected
        }
    }
})
