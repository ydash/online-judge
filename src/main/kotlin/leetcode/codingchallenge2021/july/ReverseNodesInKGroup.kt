package leetcode.codingchallenge2021.july

import leetcode.util.ListNode

class ReverseNodesInKGroup {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val root = ListNode(-1).apply { next = head }

        var i = 0
        var current = head
        var r = root
        while (current != null) {
            i++
            current = current.next
            if (i % k == 0) {
                r = reverse(r, current)
            }
        }

        return root.next
    }

    private fun reverse(parentOfHead: ListNode, childOfLast: ListNode?): ListNode {
        var current = parentOfHead.next
        var prev = parentOfHead
        val tailOfReversedList = current!!
        while (current != childOfLast) {
            val next = current?.next
            current!!.next = prev
            prev = current
            current = next
        }
        parentOfHead.next = prev
        tailOfReversedList.next = childOfLast
        return tailOfReversedList
    }
}
