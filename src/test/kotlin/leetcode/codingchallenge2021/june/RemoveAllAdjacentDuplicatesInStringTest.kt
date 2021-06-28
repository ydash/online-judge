package leetcode.codingchallenge2021.june

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class RemoveAllAdjacentDuplicatesInStringTest : StringSpec({
    "test of Remove All Adjacent Duplicates in String" {
        forAll(
            row("abbaca", "ca"),
            row("azxxzy", "ay"),
            row("aba", "aba"),
            row("a", "a"),
            row("xx", "")
        ) { input, output ->
            RemoveAllAdjacentDuplicatesInString.removeDuplicates(input) shouldBe output
        }
    }
})
