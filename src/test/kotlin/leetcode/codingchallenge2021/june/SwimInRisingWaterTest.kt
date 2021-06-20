package leetcode.codingchallenge2021.june

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class SwimInRisingWaterTest : StringSpec({
    "test of Swim in Rising Water" {
        forAll(
            row(arrayOf(intArrayOf(0, 2), intArrayOf(1, 3)), 3),
            row(arrayOf(
                intArrayOf(0, 1, 2, 3, 4),
                intArrayOf(24, 23, 22, 21, 5),
                intArrayOf(12, 13, 14, 15, 16),
                intArrayOf(11, 17, 18, 19, 20),
                intArrayOf(10, 9, 8, 7, 6)
            ), 16),
            row(arrayOf(
                intArrayOf(7, 34, 16, 12, 15, 0),
                intArrayOf(10, 26, 4, 30, 1, 20),
                intArrayOf(28, 27, 33, 35, 3, 8),
                intArrayOf(29, 9, 13, 14, 11, 32),
                intArrayOf(31, 21, 23, 24, 19, 18),
                intArrayOf(22, 6, 17, 5, 2, 25)
            ), 26),
        ) { input, output ->
            SwimInRisingWater.swimInWater(input) shouldBe output
        }
    }
})
