package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class MaxSumOfRectangleNoLargerThanKTest : StringSpec({
    "test of Max Sum of Rectangle No Longer Than k" {
        forAll(
            row(arrayOf(intArrayOf(2, 2, -1)), 3, 3),
            row(arrayOf(intArrayOf(2, 2, -1)), 4, 4),
            row(arrayOf(intArrayOf(1, 0, 1), intArrayOf(0, -2, -2)), -3, -3),
            row(arrayOf(intArrayOf(1, 0, 1), intArrayOf(0, -2, 3)), 2, 2),
            row(arrayOf(intArrayOf(-10, 2, 0), intArrayOf(0, 0, 0), intArrayOf(0, 0, 2)), -1, -6),
            row(arrayOf(intArrayOf(1, 1), intArrayOf(1, 1), intArrayOf(1, 1)), 6, 6)
        ) { matrix, k, expected ->
            MaxSumOfRectangleNoLargerThanK.maxSumSubmatrix(matrix, k) shouldBe expected
        }
    }
})
