package leetcode.codingchallenge2021.june

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class JumpGameVITest : StringSpec({
    "test of Jump Game VI" {
        forAll(
            row(intArrayOf(1, -1, -2, 4, -7, 3), 2, 7),
            row(intArrayOf(10, -5, -2, 4, 0, 3), 3, 17),
            row(intArrayOf(1, -5, -20, 4, -1, 3, -6, -3), 2, 0)
        ) { nums, k, expected ->
            JumpGameVI.maxResult(nums, k) shouldBe expected
        }
    }
})
