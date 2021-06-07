package leetcode.codingchallenge2021.june

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class MaximumAreaofaPieceofCakeTest : StringSpec({
    "test of Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts" {
        forAll(
            row(5, 4, intArrayOf(1, 2, 4), intArrayOf(1, 3), 4),
            row(5, 4, intArrayOf(3, 1), intArrayOf(1), 6),
            row(5, 4, intArrayOf(3), intArrayOf(3), 9),
            row(3, 6, intArrayOf(2), intArrayOf(5, 3, 1), 4),
            row(8, 2, intArrayOf(5), intArrayOf(1), 5)
        ) { h, w, horizontalCuts, verticalCuts, output ->
            MaximumAreaofaPieceofCake.maxArea(h, w, horizontalCuts, verticalCuts) shouldBe output
        }
    }
})
