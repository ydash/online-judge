package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class ValidTriangleNumberTest : StringSpec({
    "test of Valid Triangle Number" {
        forAll(
            row(intArrayOf(2, 2, 3, 4), 3),
            row(intArrayOf(4, 2, 3, 4), 4),
            row(intArrayOf(1), 0)
        ) { nums, expected ->
            ValidTriangleNumber().triangleNumber(nums) shouldBe expected
        }
    }
})
