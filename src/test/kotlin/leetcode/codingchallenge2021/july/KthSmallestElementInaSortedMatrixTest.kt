package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class KthSmallestElementInaSortedMatrixTest : StringSpec({
    "test of Kth Smallest Element in a Sorted Matrix" {
        forAll(
            row(arrayOf(intArrayOf(1, 5, 9), intArrayOf(10, 11, 13), intArrayOf(12, 13, 15)), 8, 13),
            row(arrayOf(intArrayOf(1), intArrayOf(10), intArrayOf(12)), 3, 12),
            row(arrayOf(intArrayOf(-5)), 1, -5)
        ) { matrix, k, expected ->
            KthSmallestElementInaSortedMatrix().kthSmallest(matrix, k) shouldBe expected
        }
    }
})
