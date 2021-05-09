package leetcode.problem

import io.kotest.data.blocking.forAll
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import leetcode.codingchallenge2021.may.SuperPalindromes

class SuperPalindromesTest : StringSpec({
    "return the number of super-palindromes integers in the inclusive range [left, right]." {
        forAll(
            row("4", "1000", 4),
            row("1", "2", 1),
            row("40000000000000000", "50000000000000000", 2)
        ) { left, right, expected ->
            SuperPalindromes.superpalindromesInRange(left, right) shouldBe expected
        }
    }

    "test" {
        SuperPalindromes.superpalindromesInRange("9944094036", "431375128285413").run { println(this) }
    }
})
