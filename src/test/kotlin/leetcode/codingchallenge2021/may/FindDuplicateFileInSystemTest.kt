package leetcode.codingchallenge2021.may

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class FindDuplicateFileInSystemTest : StringSpec({
    "Given a list paths of directory info, return a list of groups of duplicate file paths." {
        forAll(
            row(
                arrayOf(
                    "root/a 1.txt(abcd) 2.txt(efgh)",
                    "root/c 3.txt(abcd)",
                    "root/c/d 4.txt(efgh)",
                    "root 4.txt(efgh)"
                ),
                listOf(listOf("root/a/2.txt", "root/c/d/4.txt", "root/4.txt"), listOf("root/a/1.txt", "root/c/3.txt"))
            ),
            row(
                arrayOf("root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)"),
                listOf(listOf("root/a/2.txt", "root/c/d/4.txt"), listOf("root/a/1.txt", "root/c/3.txt"))
            ),
            row(
                arrayOf("root/a 1.txt(abcd) 2.txt(efsfgh)", "root/c 3.txt(abdfcd)", "root/c/d 4.txt(efggdfh)"),
                listOf()
            ),
            row(
                arrayOf("root"), listOf()
            )
        ) { input, expected ->
            val actual = FindDuplicateFileInSystem.findDuplicate(input)
            actual.size shouldBe expected.size
            actual.all { expected.contains(it) } shouldBe true
        }
    }
})
