package leetcode.codingchallenge2021.june

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class StoneGameVIITest : StringSpec({
    "test of Stone Game VII" {
        forAll(
            row(intArrayOf(5, 3, 1, 4, 2), 6),
            row(intArrayOf(7, 90, 5, 1, 100, 10, 10, 2), 122)
        ) { input, output ->
            StoneGameVIISolution.stoneGameVII(input) shouldBe output
        }
    }
})
