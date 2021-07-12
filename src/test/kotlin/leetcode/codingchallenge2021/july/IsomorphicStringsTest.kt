package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class IsomorphicStringsTest : StringSpec({
    "test of Isomorphic Strings" {
        forAll(
            row("foo", "bar", false),
            row("egg", "add", true),
            row("abc", "cbc", false),
            row("paper", "title", true),
            row("13", "42", true),
            row("\u0000", "\u0001", true),
            row("\u0000\u0000", "\u0001\u0002", false)
        ) { s, t, expected ->
            IsomorphicStrings().isIsomorphic(s, t) shouldBe expected
        }
    }
})
