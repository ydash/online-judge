package leetcode.codingchallenge2021.may

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class MinimumMovesToEqualArrayElementsTest : StringSpec({
    "Given an integer array, return the minimum number of moves required to make all array elements equal." {
        forAll(
            row(intArrayOf(1, 2, 3), 2),
            row(intArrayOf(1, 10, 2, 9), 16),
            row(intArrayOf(1, 0, 0, 8, 6), 14),
            row(intArrayOf(8), 0)
        ) { input, output ->
            MinimumMovesToEqualArrayElements.minMoves2(input) shouldBe output
        }
    }
})
