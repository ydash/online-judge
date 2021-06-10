package leetcode.codingchallenge2021.june

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class MyCalendarITest : StringSpec({
    "test1" {
        val calender = MyCalendarI()

        forAll(
            row(10, 20, true),
            row(15, 25, false),
            row(20, 30, true)
        ) { start, end, expected ->
            calender.book(start, end) shouldBe expected
        }
    }
    "test2" {
        val calender = MyCalendarI()

        forAll(
            row(47, 50, true),
            row(33, 41, true),
            row(39, 45, false),
            row(33, 42, false)
        ) { start, end, expected ->
            calender.book(start, end) shouldBe expected
        }
    }

})
