package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class NonNegativeIntegersWithoutConsecutiveOnesTest : StringSpec({
    "test of Non Negative Integers without Consecutive Ones" {
        forAll(
            row(1, 2),
            row(2, 3),
            row(5, 5),
            row(100, 34)
        ) { n, expected ->
            NonNegativeIntegersWithoutConsecutiveOnes().findIntegers(n) shouldBe expected
        }
    }
})
