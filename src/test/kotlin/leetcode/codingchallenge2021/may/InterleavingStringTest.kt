package leetcode.codingchallenge2021.may

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class InterleavingStringTest : StringSpec({
    "Given strings s1, s2 and s3, return true if s3 is formed by an interleaving of s1 and s2" {
        forAll(
            row("", "abc", "abc", true),
            row("abc", "", "abc", true),
            row("abc", "", "abd", false),
            row("", "", "a", false),
            row("aabcc", "dbbca", "aadbbcbcac", true),
            row("aabcc", "dbbca", "aadbbbaccc", false),
            row("", "", "", true)
        ) { s1, s2, s3, expected ->
            InterleavingString.isInterleave(s1, s2, s3) shouldBe expected
        }
    }
})
