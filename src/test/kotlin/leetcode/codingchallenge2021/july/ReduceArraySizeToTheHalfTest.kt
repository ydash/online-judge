package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class ReduceArraySizeToTheHalfTest : StringSpec({
    "test of Reduce Array Size to the Half" {
        forAll(
            row(intArrayOf(3, 3, 3, 3, 5, 5, 5, 2, 2, 7), 2),
            row(intArrayOf(7, 7, 7, 7, 7, 7), 1),
            row(intArrayOf(1, 2), 1),
            row(intArrayOf(100, 100, 3, 7), 1),
            row(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 5)
        ) { arr, expected ->
            ReduceArraySizeToTheHalf().minSetSize(arr) shouldBe expected
        }
    }
})
