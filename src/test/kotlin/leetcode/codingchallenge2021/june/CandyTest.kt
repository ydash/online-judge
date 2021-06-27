package leetcode.codingchallenge2021.june

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CandyTest : StringSpec({
    "test of Candy" {
        forAll(
            row(intArrayOf(1, 0, 2), 5),
            row(intArrayOf(1, 2, 2), 4),
            row(intArrayOf(1, 2, 3, 4, 5, 2, 1), 18),
            row(intArrayOf(5, 4, 3, 2, 1, 2, 5), 20),
            row(intArrayOf(1, 2, 8, 8, 8, 2, 1), 13),
            row(intArrayOf(0), 1)
        ) { ratings, expected ->
            CandySolution.candy(ratings) shouldBe expected
        }
    }
})
