package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class FindKClosestElementsTest : StringSpec({
    "test of FInd Closest K Elements" {
        forAll(
            row(IntArray(5) { it + 1 }, 4, 3, (1..4).toList()),
            row(IntArray(5) { it + 1 }, 4, -1, (1..4).toList()),
            row(intArrayOf(1, 3, 5, 7), 1, 4, listOf(3)),
            row(intArrayOf(10), 1, 1, listOf(10))
        ) { arr, k, x, expected ->
            FindKClosestElements.findClosestElements(arr, k, x) shouldBe expected
        }
    }
})
