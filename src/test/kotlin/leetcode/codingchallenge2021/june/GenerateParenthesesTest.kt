package leetcode.codingchallenge2021.june

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class GenerateParenthesesTest : StringSpec({
    "test of Generate Parentheses" {
        forAll(
            row(1, listOf("()")),
            row(3, listOf("((()))", "(()())", "(())()", "()(())", "()()()")),
        ) { num, expected ->
            val actual = GenerateParentheses.generateParenthesis(num)
            actual shouldBe expected
        }
    }
})
