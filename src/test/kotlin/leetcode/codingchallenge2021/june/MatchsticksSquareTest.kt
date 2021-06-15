package leetcode.codingchallenge2021.june

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class MatchsticksSquareTest : StringSpec({
    "test of Matchsticks to Square" {
        forAll(
            row(intArrayOf(1, 1, 2, 2, 2), true),
            row(intArrayOf(3, 3, 3, 3, 4), false),
            row(intArrayOf(1), false),
            row(intArrayOf(1, 3, 5, 7), false),
            row(intArrayOf(1, 1, 1, 1, 1, 1, 1, 2, 3, 8, 2, 1, 5, 2, 2), true),
            row(intArrayOf(1, 1, 1, 1, 1, 1, 1, 2, 3, 8, 2, 1, 5, 2), false)
        ) { input, output ->
            MatchsticksSquare.makesquare(input) shouldBe output
        }
    }
})
