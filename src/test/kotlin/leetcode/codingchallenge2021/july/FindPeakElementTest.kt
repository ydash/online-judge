package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class FindPeakElementTest : StringSpec({
    "test of Find Peak Element" {
        forAll(
            row(intArrayOf(1), 0),
            row(intArrayOf(0, 1), 1),
            row(intArrayOf(1, 0), 0),
            row(intArrayOf(1, 2, 3, 4, 5), 4),
            row(intArrayOf(5, 4, 3, 2, 1), 0),
            row(intArrayOf(1, 2, 3, 1), 2),
            row(intArrayOf(1, 2, 1, 3, 5, 6, 4), 5),
            row(intArrayOf(0, 1, 5, 3, 2, 1, 0), 2)
        ) { nums, expected ->
            FindPeakElementSolution().findPeakElement(nums) shouldBe expected
        }
    }
})
