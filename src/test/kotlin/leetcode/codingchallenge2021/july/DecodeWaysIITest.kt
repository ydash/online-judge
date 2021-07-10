package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class DecodeWaysIITest : StringSpec({
    "test of Decode Ways II" {
        forAll(
            row("*", 9),
            row("1", 1),
            row("0", 0),
            row("1*", 18),
            row("1*1", 20),
            row("2*1", 17),
            row("**9", 105),
            row("2920", 1),
            row("101", 1),
            row("***", 999),
            row("*******", 11859129),
            row("*1**9*2*4*", 3094875),
            row("**********", 483456820),
            row("************", 814157245)
        ) { s, expected ->
            DecodeWaysII().numDecodings(s) shouldBe expected
        }
    }
})
