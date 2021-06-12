package leetcode.codingchallenge2021.june

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class MinimumRefuelingStopsTest : StringSpec({
    "add test of Minimum Refueling Stops" {
        forAll(
            row(1, 1, arrayOf(), 0),
            row(100, 1, arrayOf(), -1),
            row(10, 100, arrayOf(intArrayOf(10, 10), intArrayOf(50, 10)), 0),
            row(100, 1, arrayOf(intArrayOf(10, 100)), -1),
            row(100, 10, arrayOf(intArrayOf(10, 60), intArrayOf(20, 30), intArrayOf(30, 30), intArrayOf(60, 40)), 2)
        ) { target, startFuel, stations, expected ->
            MinimumRefuelingStops.minRefuelStops(target, startFuel, stations) shouldBe expected
        }
    }
})
