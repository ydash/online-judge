package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class FindMedianFromDataStreamTest : StringSpec({
    "test of Find Median from Data Stream" {
        val finder = MedianFinder()
        forAll(
            row(1,1.0),
            row(2,1.5),
            row(2, 2.0)
        ) { num, expected ->
            finder.addNum(num)
            finder.findMedian() shouldBe expected
        }
    }
})
