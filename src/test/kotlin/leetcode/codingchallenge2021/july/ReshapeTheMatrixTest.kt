package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class ReshapeTheMatrixTest : StringSpec({
    "test of Reshape the Matrix" {
        forAll(
            row(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)), 1, 4, arrayOf(intArrayOf(1, 2, 3, 4))),
            row(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)), 3, 2,
                arrayOf(intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(5, 6)))
        ) { mat, r, c, expected ->
            ReshapeTheMatrix().matrixReshape(mat, r, c) shouldBe expected
        }
    }
})
