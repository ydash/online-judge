package leetcode.codingchallenge2021.may

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class SearchSuggestionsSystemTest : StringSpec({
    "Given an array of strings `products` and a string `searchWord`, return a list of lists of the suggested `products` after each character of `searchWord` is typed." {
        forAll(
            row(
                arrayOf("mobile", "mouse", "moneypot", "monitor", "mousepad"),
                "mouse",
                listOf(
                    listOf("mobile", "moneypot", "monitor"),
                    listOf("mobile", "moneypot", "monitor"),
                    listOf("mouse", "mousepad"),
                    listOf("mouse", "mousepad"),
                    listOf("mouse", "mousepad")
                )
            ),
            row(
                arrayOf("havana"),
                "tatiana",
                listOf(emptyList(), emptyList(), emptyList(), emptyList(), emptyList(), emptyList(), emptyList())
            )
        ) { products, searchWord, expected ->
            SearchSuggestionsSystem.suggestedProducts(products, searchWord) shouldBe expected
        }
    }
})
