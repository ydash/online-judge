package leetcode.problem

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class EditDistanceTest : StringSpec({
    "minDistance(word1, word2) returns levenshtein distance between word1 and word2." {
        forAll(
            row("sea", "eat", 2),
            row("leetcode", "etco", 4),
            row("sea", "abs", 3),
            row("abcdefg", "hijklmn", 7)
        ) { str1: String, str2: String, expected ->
            EditDistance().minDistance(str1, str2) shouldBe expected
        }
    }

})
