package leetcode.codingchallenge2021.june

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RangeSumQueryTest : StringSpec({
    "test of Range Sum Query 1" {
        val numArray = NumArray(intArrayOf(1, 3, 5))
        numArray.sumRange(0, 2) shouldBe 9
        numArray.update(1, 2)
        numArray.sumRange(0, 2) shouldBe 8
    }

    "test of Range Sum Query 2" {
        val numArray = NumArray(intArrayOf(1, 3, 5, 7, 9))
        numArray.sumRange(2, 2) shouldBe 5
        numArray.sumRange(1, 3) shouldBe 15
        numArray.update(2, 100)
        numArray.sumRange(1, 3) shouldBe 110
    }

})
