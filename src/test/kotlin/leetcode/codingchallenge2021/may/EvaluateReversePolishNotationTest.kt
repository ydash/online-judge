package leetcode.codingchallenge2021.may

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class EvaluateReversePolishNotationTest : StringSpec({
    "evaluate reverse polish notation" {
        forAll(
            row(arrayOf("2", "1", "+", "3", "*"), 9),
            row(arrayOf("4", "13", "5", "/", "+"), 6)
        ) { input, output ->
            EvaluateReversePolishNotation.evalRPN(input) shouldBe output
        }
    }
})
