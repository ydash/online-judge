package leetcode.codingchallenge2021.may

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class SubsetsTest : StringSpec({
    "Given an integer array, return all possible subsets." {
        forAll(
            row(
                intArrayOf(1, 2, 3),
                listOf(
                    listOf(), listOf(1), listOf(2), listOf(1, 2), listOf(3),
                    listOf(1, 3), listOf(2, 3), listOf(1, 2, 3)
                )
            ),
            row(intArrayOf(0), listOf(listOf(), listOf(0)))
        ) { input, expected ->
            val actual = SubsetsSolution.subsets(input)
            actual.toSet() shouldBe expected.toSet()
        }
    }
})
