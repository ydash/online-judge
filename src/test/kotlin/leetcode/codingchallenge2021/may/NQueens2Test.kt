package leetcode.codingchallenge2021.may

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class NQueens2Test : StringSpec({
    "Given an integer n, return the number of solutions for placing n queens." {
        forAll(
            row(4, 2),
            row(1, 1),
            row(2, 0),
            row(9, 352)
        ) { input, output ->
            NQueens2.totalNQueens(input) shouldBe output
        }
    }

    "Given coordinates which a queen have already been placed, return the all patterns" {
        forAll(
            row(
                4, 2, listOf(Coordinate(0, 2), Coordinate(1, 0)),
                listOf(
                    listOf(Coordinate(0, 2), Coordinate(1, 0), Coordinate(2, 3))
                )
            )
        ) { n, next, currentState, expected ->
            NQueens2.next(n, next, currentState) shouldBe expected
        }
    }
})
