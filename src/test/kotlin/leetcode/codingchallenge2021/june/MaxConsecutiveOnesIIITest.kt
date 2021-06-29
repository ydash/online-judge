package leetcode.codingchallenge2021.june

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class MaxConsecutiveOnesIIITest : StringSpec({
    "test of Max Consecutive Ones III" {
        forAll(
            row(intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0), 2, 6),
            row(intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1), 3, 10),
            row(intArrayOf(0, 0, 0, 0, 0), 2, 2),
            row(IntArray(100000) { 1 }, 0, 100000),
            row(IntArray(100000), 1, 1)
        ) { nums, k, expected ->
            MaxConsecutiveOnesIII.longestOnes(nums, k) shouldBe expected
        }
    }
})
