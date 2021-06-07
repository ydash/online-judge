package leetcode.codingchallenge2021.may

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LongestConsecutiveSequenceTest : StringSpec({
    "Given integer array `nums`, return the length of the longest consecutive elements sequence." {
        forAll(
            row(intArrayOf(100, 4, 200, 1, 3, 2), 4),
            row(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1), 9),
            row(intArrayOf(), 0)
        ) { input, output ->
            LongestConsecutiveSequence.longestConsecutive(input) shouldBe output
        }
    }
})
