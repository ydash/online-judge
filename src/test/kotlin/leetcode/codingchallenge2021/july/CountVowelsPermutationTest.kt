package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CountVowelsPermutationTest : StringSpec({
    "test of Count Vowels Permutation" {
        forAll(
            row(1, 5),
            row(2, 10),
            row(5, 68),
            row(871, 715828952),
            row(10000, 76428576)
        ) { n, expected ->
            CountVowelsPermutation().countVowelPermutation(n) shouldBe expected
        }
    }
})
