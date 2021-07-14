package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CustomSortStringTest : StringSpec({
    "test of Custom Sort String" {
        forAll(
            row("cba", "abcd", "cbad"),
            row("def", "abcdefdefce", "ddeeeffabcc")
        ) { order, str, expected ->
            CustomSortStringSolution().customSortString(order, str) shouldBe expected
        }
    }
})
