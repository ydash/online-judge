package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class ZeroOneMatrixTest : StringSpec({
    "test of 01 Matrix" {
        forAll(
            row(
                arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 0)),
                arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 0))
            ),
            row(
                arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(1, 1, 1)),
                arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(1, 2, 1))
            ),
            row(
                arrayOf(intArrayOf(0, 1, 0, 1, 1)),
                arrayOf(intArrayOf(0, 1, 0, 1, 2))
            ),
            row(
                arrayOf(intArrayOf(1), intArrayOf(1), intArrayOf(0)),
                arrayOf(intArrayOf(2), intArrayOf(1), intArrayOf(0))
            )
        ) { mat, expected ->
            ZeroOneMatrix().updateMatrix(mat) shouldBe expected
        }
    }
})
