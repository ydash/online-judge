package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class PartitionArrayIntoDisjointIntervalsTest : StringSpec({
    "test of Partition Array into Disjoint Intervals" {
        forAll(
            row(intArrayOf(5, 0, 3, 8, 6), 3),
            row(intArrayOf(1, 1, 1, 0, 6, 12), 4),
            row(intArrayOf(5, 3, 5, 5, 5), 2),
            row(intArrayOf(1, 7, 1, 0, 6, 12), 5)
        ) { nums, expected ->
            PartitionArrayIntoDisjointIntervals().partitionDisjoint(nums) shouldBe expected
        }
    }
})
