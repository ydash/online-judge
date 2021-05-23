package leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import leetcode.codingchallenge2021.may.FindTheShortestSuperString

class FindTheShortestSuperStringTest : StringSpec({
    "Given an array of strings `words`, return the smallest string that contains each string in words as a substring." {
        forAll(
            row(arrayOf("alex", "loves", "leetcode"), 17),
            row(arrayOf("catg", "ctaagt", "gcta", "ttca", "atgcatc"), 16),
            row(arrayOf("aaa", "aab", "abb", "bba", "bbb"), 7),
            row(arrayOf("abcdef", "efde", "defab"), 11)
        ) { input, expectedLength ->
            val result = FindTheShortestSuperString.shortestSuperstring(input)
            result.length shouldBe expectedLength
            input.all { result.contains(it) } shouldBe true
        }
    }
})
