package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class MaximumLengthOfRepeatedSubarrayTest : StringSpec({
    "test of Maximum Length of Repeated Subarray" {
        forAll(
            row(intArrayOf(1, 2, 3, 2, 1), intArrayOf(3, 2, 1, 4, 7), 3),
            row(intArrayOf(0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0), 5)
        ) { nums1, nums2, expected ->
            MaximumLengthOfRepeatedSubarray().findLength(nums1, nums2) shouldBe expected
        }
    }
})
