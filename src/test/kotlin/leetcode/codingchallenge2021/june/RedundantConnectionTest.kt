package leetcode.codingchallenge2021.june

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class RedundantConnectionTest : StringSpec({
    "test of Redundant Connection" {
        forAll(
            row(arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 3)), intArrayOf(2, 3)),
            row(arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(3, 4),
                intArrayOf(1, 4),
                intArrayOf(1, 5)),
                intArrayOf(1, 4)
            ),
            row(arrayOf(
                intArrayOf(9, 10),
                intArrayOf(5, 8),
                intArrayOf(2, 6),
                intArrayOf(1, 5),
                intArrayOf(3, 8),
                intArrayOf(4, 9),
                intArrayOf(8, 10),
                intArrayOf(4, 10),
                intArrayOf(6, 8),
                intArrayOf(7, 9)),
                intArrayOf(4, 10)
            ),
            row(arrayOf(intArrayOf(1, 4), intArrayOf(3, 4), intArrayOf(1, 3), intArrayOf(1, 2), intArrayOf(4, 5)),
                intArrayOf(1, 3))
        ) { input, output ->
            RedundantConnection.findRedundantConnection(input) shouldBe output
        }
    }
})
