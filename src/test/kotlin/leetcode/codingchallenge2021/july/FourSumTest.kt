package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class FourSumTest : StringSpec({
    "test of Four Sum" {
        forAll(
            row(intArrayOf(1, 0, -1, 0, -2, 2), 0,
                arrayOf(intArrayOf(-2, -1, 1, 2), intArrayOf(-2, 0, 0, 2), intArrayOf(-1, 0, 0, 1))),
            row(intArrayOf(2, 2, 2, 2), 8, arrayOf(intArrayOf(2, 2, 2, 2))),
        ) { nums, target, expected ->
            FourSumSolution().fourSum(nums, target) shouldBe expected
        }
    }
})
