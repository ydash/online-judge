package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import leetcode.util.ListNode

class ReverseNodesInKGroupTest : StringSpec({
    "test of Reverse Nodes in K Group" {
        forAll(
            row(ListNode.ofList(listOf(1, 2, 3, 4, 5)), 3, ListNode.ofList(listOf(3, 2, 1, 4, 5))),
            row(ListNode.ofList(listOf(1, 2, 3, 4, 5)), 1, ListNode.ofList(listOf(1, 2, 3, 4, 5))),
            row(ListNode.ofList(listOf(1)), 1, ListNode.ofList(listOf(1))),
            row(ListNode.ofList(listOf(1, 2, 3, 4)), 2, ListNode.ofList(listOf(2, 1, 4, 3)))
        ) { head, k, expected ->
            ReverseNodesInKGroup().reverseKGroup(head, k)!!.toList() shouldBe expected!!.toList()
        }
    }
})
