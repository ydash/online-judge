package leetcode.weeklycontest

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import leetcode.weeklycontest.Contest244P1.rotateRight

class Contest244Test : StringSpec({
    "test p1" {
        forAll(
            row(arrayOf(intArrayOf(0, 1), intArrayOf(1, 0)), arrayOf(intArrayOf(1, 0), intArrayOf(0, 1)), true),
            row(arrayOf(intArrayOf(0, 1), intArrayOf(1, 1)), arrayOf(intArrayOf(1, 0), intArrayOf(0, 1)), false),
            row(arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(1, 1, 1)),
                arrayOf(intArrayOf(1, 1, 1), intArrayOf(0, 1, 0), intArrayOf(0, 0, 0)),
                true),
            row(arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 1), intArrayOf(0, 0, 1)),
                arrayOf(intArrayOf(1, 1, 1), intArrayOf(0, 1, 0), intArrayOf(0, 0, 0)),
                true)
        ) { mat, target, expected ->
            Contest244P1.findRotation(mat, target) shouldBe expected
        }
    }

    "test p1.1" {
        Contest244P1.equal(arrayOf(intArrayOf(0, 1), intArrayOf(1, 0)),
            arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))) shouldBe true

        Contest244P1.equal(arrayOf(intArrayOf(0, 1), intArrayOf(1, 0)),
            arrayOf(intArrayOf(0, 1), intArrayOf(1, 1))) shouldBe false
    }

    "test p1.2" {
        arrayOf(intArrayOf(0, 1), intArrayOf(1, 0)).rotateRight() shouldBe
                arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))
    }

    "test p2" {
        forAll(
            row(intArrayOf(5, 1, 3), 3),
            row(intArrayOf(1, 1, 1), 0),
            row(intArrayOf(1, 1, 2, 2, 3), 4),
            row(intArrayOf(7, 9, 10, 8, 6, 4, 1, 5, 2, 3), 45)
        ) { input, output ->
            Contest244P2.reductionOperations(input) shouldBe output
        }
    }

    "test p3" {
        forAll(
            row("001", 0),
            row("110", 0),
            row("111000", 2),
            row("010", 0),
            row("1110", 1)
        ) { input, output ->
            Contest244P3.minFlips(input) shouldBe output
        }
    }
})
