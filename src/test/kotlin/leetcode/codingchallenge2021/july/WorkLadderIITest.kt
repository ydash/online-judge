package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class WorkLadderIITest : StringSpec({
    "test of Work Ladder II" {
        forAll(
            row("hit", "cog",
                listOf("hot", "dot", "dog", "lot", "log", "cog"),
                listOf(listOf("hit", "hot", "dot", "dog", "cog"), listOf("hit", "hot", "lot", "log", "cog"))
            ),
            row("hit", "cog",
                listOf("hot", "dot", "dog", "lot", "log"),
                emptyList()
            ),
            row("hit", "cog",
                listOf("cog", "log", "lot", "dog", "dot", "hot"),
                listOf(listOf("hit", "hot", "dot", "dog", "cog"), listOf("hit", "hot", "lot", "log", "cog"))
            ),
            row("hot", "dog",
                listOf("hot", "dog", "dot"),
                listOf(listOf("hot", "dot", "dog"))
            ),
            row("red",
                "tax",
                listOf("ted", "tex", "red", "tax", "tad", "den", "rex", "pee"),
                listOf(listOf("red", "ted", "tad", "tax"),
                    listOf("red", "ted", "tex", "tax"),
                    listOf("red", "rex", "tex", "tax"))
            )
        ) { beginWord, endWord, wordList, expected ->
            WorkLadderII().findLadders(beginWord, endWord, wordList) shouldBe expected
        }
    }
})
