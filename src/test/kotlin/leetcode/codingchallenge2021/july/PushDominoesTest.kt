package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class PushDominoesTest : StringSpec({
    "test of Push Dominoes" {
        forAll(
            row(".", "."),
            row("R", "R"),
            row("L", "L"),
            row(".LR.", "LLRR"),
            row(".L.LR.R.", "LLLLRRRR"),
            row("..R...L..", "..RR.LL.."),
            row(".L.R...LR....L..", "LL.RR.LLRRRLLL..")
        ) { dominoes, expected ->
            PushDominoesSolution().pushDominoes(dominoes) shouldBe expected
        }
    }
})
