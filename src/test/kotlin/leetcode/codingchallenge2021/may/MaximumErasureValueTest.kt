package leetcode.codingchallenge2021.may

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class MaximumErasureValueTest : StringSpec({
    "test" {
        forAll(
            row(intArrayOf(4, 2, 4, 5, 6), 17),
            row(intArrayOf(5, 2, 1, 2, 5, 2, 1, 2, 5), 8),
            row(intArrayOf(100, 3, 8, 3, 9, 5), 111)
        ) { input, output ->
            MaximumErasureValue.maximumUniqueSubarray(input) shouldBe output
        }
    }
})
