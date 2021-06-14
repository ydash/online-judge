package leetcode.codingchallenge2021.june

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class MaximumUnitsTruckTest : StringSpec({
    "test of Maximum Units on a Truck" {
        forAll(
            row(arrayOf(intArrayOf(1, 3), intArrayOf(2, 2), intArrayOf(3, 1)), 4, 8),
            row(arrayOf(intArrayOf(5, 10), intArrayOf(2, 5), intArrayOf(4, 7), intArrayOf(3, 9)), 10, 91)
        ) { boxTypes, truckSize, expected ->
            MaximumUnitsTruck.maximumUnits(boxTypes, truckSize) shouldBe expected
        }
    }
})
