package leetcode.codingchallenge2021.june

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class NumberOfSubArraysWithBoundedMaximumTest : StringSpec({
    "test" {
        forAll(
            row(intArrayOf(2, 1, 4, 3), 2, 3, 3)
        ) { nums, left, right, expected ->
            NumberOfSubArraysWithBoundedMaximum.numSubarrayBoundedMax(nums, left, right) shouldBe expected
        }
    }
})
