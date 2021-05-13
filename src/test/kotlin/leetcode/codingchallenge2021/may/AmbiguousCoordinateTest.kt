package leetcode.codingchallenge2021.may

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class AmbiguousCoordinateTest : StringSpec({
    "Return a list of strings representing all possibilities for what our original coordinates could have been" {
        forAll(
            row("(123)", listOf("(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)")),
            row("(00011)", listOf("(0.001, 1)", "(0, 0.011)")),
            row("(0123)", listOf("(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)")),
            row("(100)", listOf("(10, 0)"))
        ) { input, output ->
            val result = AmbiguousCoordinate.ambiguousCoordinates(input).also {
                println(it)
            }
            result.size shouldBe output.size
            result.all { output.contains(it) } shouldBe true
        }
    }

    "insert decimal point" {
        forAll(
            row("123", listOf("123", "1.23", "12.3")),
            row("012", listOf("0.12")),
            row("110", listOf("110")),
            row("101", listOf("101", "1.01", "10.1"))
        ) { input, output ->
            AmbiguousCoordinate.insertDecimalPoint(input) shouldBe output
        }
    }
})
