package leetcode.codingchallenge2021.june

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class MinCostClimbingStairsTest : StringSpec({
    "test" {
        forAll(
            row(intArrayOf(10, 15, 20), 15),
            row(intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1), 6)
        ) { input, output ->
            MinCostClimbingStairsSolution.minCostClimbingStairs(input) shouldBe output
        }
    }
})
