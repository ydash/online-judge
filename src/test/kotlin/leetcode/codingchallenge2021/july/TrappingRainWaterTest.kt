package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class TrappingRainWaterTest : StringSpec({
    "test of Trapping Rain Water" {
        forAll(
            row(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1), 6),
            row(intArrayOf(4, 2, 0, 3, 2, 5), 9),
            row(intArrayOf(), 0)
        ) { height, expected ->
            TrappingRainWater().trap(height) shouldBe expected
        }
    }
})
