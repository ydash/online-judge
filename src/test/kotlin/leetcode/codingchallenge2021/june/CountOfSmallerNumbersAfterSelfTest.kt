package leetcode.codingchallenge2021.june

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CountOfSmallerNumbersAfterSelfTest : StringSpec({
    "test" {
        forAll(
            row(intArrayOf(5, 2, 6, 1), listOf(2, 1, 1, 0)),
            row(intArrayOf(-1), listOf(0)),
            row(intArrayOf(-1, -1), listOf(0, 0)),
            row(intArrayOf(10000, -10000), listOf(1, 0)),
            row(intArrayOf(5, 4, 3, 2, 1), listOf(4, 3, 2, 1, 0)),
            row(IntArray(20001) { it - 10000 }.reversed().toIntArray(), (20000 downTo 0).toList()),
            row(intArrayOf(5, 3, 7, 3, 1, 8, 4, 3), listOf(5, 1, 4, 1, 0, 2, 1, 0))
        ) { input, output ->
            CountOfSmallerNumbersAfterSelf.countSmaller(input) shouldBe output
        }
    }
})
