package leetcode.codingchallenge2021.june

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class OutOfBoundaryPathsTest : StringSpec({
    "test of Out of Boundary Paths" {
        forAll(
            row(2, 2, 2, 0, 0, 6),
            row(1, 3, 3, 0, 1, 12)
        ) { m, n, maxMove, startRow, startColumn, expected ->
            OutOfBoundaryPaths.findPaths(m, n, maxMove, startRow, startColumn) shouldBe expected
        }
    }
})
