package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LongestIncreasingSubsequenceTest : StringSpec({
    "test of Longest Increasing Subsequence" {
        forAll(
            row(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18), 4),
            row(intArrayOf(0, 1, 0, 3, 2, 3), 4),
            row(intArrayOf(7, 7, 7, 7, 7, 7, 7), 1)
        ) { nums, expected ->
            LongestIncreasingSubsequence().lengthOfLIS(nums) shouldBe expected
        }
    }
})
