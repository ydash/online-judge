package leetcode.codingchallenge2021.may

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class NQueensTest : StringSpec({
    "solve n-queens puzzle" {
        forAll(
            row(4, listOf(listOf(".Q..", "...Q", "Q...", "..Q."), listOf("..Q.", "Q...", "...Q", ".Q.."))),
            row(1, listOf(listOf("Q"))),
            row(2, emptyList())
        ) { input, output ->
            NQueens.solveNQueens(input) shouldBe output
        }
    }

    "given coordinates where the Q is already placed and a coordinate `p` where the Q will be placed, return true if the Q can be placed in the `p`" {
        forAll(
            row(emptyList(), Pair(1, 1), true),
            row(listOf(Pair(5, 5)), Pair(7, 3), false),
            row(listOf(Pair(5, 5)), Pair(7, 7), false),
            row(listOf(Pair(5, 5)), Pair(4, 3), true),
            row(listOf(Pair(0, 1), Pair(1, 3)), Pair(2, 0), true),
            row(listOf(Pair(0, 1), Pair(1, 3)), Pair(3, 1), false),
        ) { placedCoordList, p, expected ->
            NQueens.canPlace(placedCoordList, p) shouldBe expected
        }
    }
})
