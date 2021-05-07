package leetcode.codingchallenge2021.may

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class DeleteOperationForTwoStringsTest : StringSpec({
    "minDistance(word1, word2) returns minimum number of steps required to make word1 and word2 the same." {
        forAll(
            row("sea", "eat", 2),
            row("leetcode", "etco", 4),
            row("sea", "abs", 4),
            row("abcdefg", "hijklmn", 14)
        ) { str1: String, str2: String, expected ->
            DeleteOperationForTwoStrings().minDistance(str1, str2) shouldBe expected
        }
    }
})
