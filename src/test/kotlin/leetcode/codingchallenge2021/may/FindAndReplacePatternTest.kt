package leetcode.codingchallenge2021.may

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class FindAndReplacePatternTest : StringSpec({
    "Given a list of strings `words` and a string `pattern`, return a list of word that match pattern" {
        forAll(
            row(arrayOf("abc", "deq", "mee", "aqq", "dkd", "ccc"), "abb", listOf("mee", "aqq")),
            row(arrayOf("a", "b", "c"), "a", listOf("a", "b", "c")),
            row(arrayOf("a", "b", "c"), "a", listOf("a", "b", "c"))
        ) { words, pattern, expected ->
            FindAndReplacePatternSolution.findAndReplacePattern(words, pattern) shouldBe expected
        }
    }

    "return true, if word match pattern" {
        forAll(
            row("abb", "abc", false),
            row("abb", "mee", true),
            row("abb", "abbb", false),
            row("a", "b", true),
            row("abb", "ccc", false),
            row("ccc", "abb", false)
        ) { pattern, word, expected ->
            FindAndReplacePatternSolution.match(pattern, word) shouldBe expected
        }
    }
})
