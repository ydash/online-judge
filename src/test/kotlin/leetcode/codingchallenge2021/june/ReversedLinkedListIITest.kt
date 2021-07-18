package leetcode.codingchallenge2021.june

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import leetcode.util.ListNode

class ReversedLinkedListIITest : StringSpec({
    "test of Reversed Linked List II" {
        forAll(
            row(ListNode.ofList(listOf(1, 2, 3, 4, 5)), 2, 4, listOf(1, 4, 3, 2, 5)),
            row(ListNode.ofList(listOf(3, 5)), 1, 2, listOf(5, 3)),
            row(ListNode.ofList(listOf(3, 5)), 1, 1, listOf(3, 5)),
            row(ListNode.ofList(listOf(1, 2, 3, 4, 5)), 3, 4, listOf(1, 2, 4, 3, 5))
        ) { head, left, right, expected ->
            ReversedLinkedListII.reverseBetween(head, left, right)!!.toList() shouldBe expected
        }
    }
})
