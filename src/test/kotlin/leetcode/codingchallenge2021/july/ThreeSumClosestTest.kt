package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class ThreeSumClosestTest : StringSpec({
    "test of 3 Sum Closest" {
        forAll(
            row(intArrayOf(0, 0, 0), 1, 0),
            row(intArrayOf(-1, -1, -1), 1, -3),
            row(intArrayOf(1, 10, 100), -100, 111),
            row(intArrayOf(-1, 2, 1, -4), 1, 2),
            row(intArrayOf(-1, 2, 1, -4), -1, -1)
        ) { nums, target, expected ->
            ThreeSumClosestSolution().threeSumClosest(nums, target) shouldBe expected
        }
    }
})
