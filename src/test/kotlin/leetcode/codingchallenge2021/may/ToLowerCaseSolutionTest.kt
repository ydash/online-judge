package leetcode.codingchallenge2021.may

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class ToLowerCaseSolutionTest : StringSpec({
    "Given a string, return the string after replacing every uppercase letter with the same lowercase letter" {
        forAll(
            row("Hello", "hello"),
            row("hello", "hello"),
            row("LOVELY", "lovely")
        ) { input, output ->
            ToLowerCaseSolution.toLowerCase(input) shouldBe output
        }
    }
})
