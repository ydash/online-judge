package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class ThreeEqualPartsTest : StringSpec({
    "test of Three Equal Parts" {
        forAll(
            row(intArrayOf(0, 0, 0), intArrayOf(0, 2)),
            row(intArrayOf(1, 0, 1, 0, 1), intArrayOf(0, 3)),
            row(intArrayOf(1, 1, 0, 1, 1), intArrayOf(-1, -1)),
            row(intArrayOf(1, 1, 0, 0, 1), intArrayOf(0, 2)),
            row(intArrayOf(1, 1, 1, 1, 1, 1), intArrayOf(1, 4))
        ) { arr, expected ->
            ThreeEqualPartsSolution().threeEqualParts(arr) shouldBe expected
        }
    }
})
