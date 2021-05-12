package leetcode.codingchallenge2021.may

import io.kotest.data.blocking.forAll
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class NumMatrixTest : StringSpec({
    "Calculate the sum of the elements of matrix inside the rectangle." {
        val matrix = NumMatrix(
            arrayOf(
                intArrayOf(3, 0, 1, 4, 2),
                intArrayOf(5, 6, 3, 2, 1),
                intArrayOf(1, 2, 0, 1, 5),
                intArrayOf(4, 1, 0, 1, 7),
                intArrayOf(1, 0, 3, 0, 5)
            )
        )
        forAll(
            row(2, 1, 4, 3, 8),
            row(1, 1, 2, 2, 11),
            row(1, 2, 2, 4, 12)
        ) { row1, col1, row2, col2, expected ->
            matrix.sumRegion(row1, col1, row2, col2) shouldBe expected
        }
    }
})
