package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class MaxSumOfRectangleNoLargerThanKTest : StringSpec({
    "test of Max Sum of Rectangle No Longer Than k" {
        forAll(
            row(arrayOf(intArrayOf(2, 2, -1)), 3, 3),
            row(arrayOf(intArrayOf(2, 2, -1)), 4, 4),
            row(arrayOf(intArrayOf(1, 0, 1), intArrayOf(0, -2, -2)), -3, -3),
            row(arrayOf(intArrayOf(1, 0, 1), intArrayOf(0, -2, 3)), 2, 2),
            row(arrayOf(intArrayOf(-10, 2, 0), intArrayOf(0, 0, 0), intArrayOf(0, 0, 2)), -1, -6),
            row(arrayOf(intArrayOf(1, 1), intArrayOf(1, 1), intArrayOf(1, 1)), 6, 6),
            row(arrayOf(intArrayOf(5, -4, -3, 4), intArrayOf(-3, -4, 4, 5), intArrayOf(5, 1, 5, -4)), 3, 2)
        ) { matrix, k, expected ->
            MaxSumOfRectangleNoLargerThanK.maxSumSubmatrix(matrix, k) shouldBe expected
        }
    }

    "Max Sum of Rectangle in 1D array" {
        val arr = intArrayOf(2, 2, -1)
        val n = arr.size
        var max = Int.MIN_VALUE
        var sum = 0
        (0 until n).forEach { j ->
            if (j == 0) {
                max = arr[j]
                sum += arr[j]
            } else {
                sum = maxOf(sum + arr[j], arr[j])
                max = maxOf(sum, max)
            }
        }

        max shouldBe 4
    }

    "Max Sum of Rectangle no longer k in 1D array" {
        val arr = intArrayOf(2, 2, 2)
        val k = 3
        var max = Int.MIN_VALUE
        var sum = 0
        val acc = sortedSetOf(0)
        arr.forEach { num ->
            sum += num
            val x = acc.ceiling(sum - k)
            if (x != null) max = maxOf(max, sum - x)
            acc += sum
            println("$sum,$x,$acc")
        }

        max shouldBe 2
    }

})
