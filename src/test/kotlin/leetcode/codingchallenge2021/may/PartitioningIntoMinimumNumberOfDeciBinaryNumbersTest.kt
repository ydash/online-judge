package leetcode.codingchallenge2021.may

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class PartitioningIntoMinimumNumberOfDeciBinaryNumbersTest : StringSpec({
    "Given a string n that represents a positive decimal integer, return the minimum number of positive dici-deci-binary numbers needed so that they sum up to n" {
        forAll(
            row("4", 4),
            row("32", 3),
            row("82734", 8),
            row("27346209830709182346", 9)
        ) { input, output ->
            PartitioningIntoMinimumNumberOfDeciBinaryNumbers.minPartitions(input) shouldBe output
        }
    }
})
