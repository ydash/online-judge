package leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import leetcode.codingchallenge2021.may.FindTheShortestSuperString

class FindTheShortestSuperStringTest : StringSpec({
    "Given an array of strings `words`, return the smallest string that contains each string in words as a substring." {
        forAll(
            row(arrayOf("alex", "loves", "leetcode"), "alexlovesleetcode"),
            row(arrayOf("catg", "ctaagt", "gcta", "ttca", "atgcatc"), "gctaagttcatgcatc")
        ) { input, output ->
            FindTheShortestSuperString.shortestSuperstring(input) shouldBe output
        }
    }
})
