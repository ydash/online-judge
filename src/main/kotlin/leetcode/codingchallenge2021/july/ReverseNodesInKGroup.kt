package leetcode.codingchallenge2021.july

import leetcode.util.ListNode

class ReverseNodesInKGroup {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val root = ListNode(-1).apply { next = head }

        var current = head
        var pointer = root
        while (current != null) {
            val acc = Array<ListNode?>(k) { null }
            for (i in acc.indices.reversed()) {
                acc[i] = current
                current = current?.next
            }
            if (acc[0] == null) break

            acc.forEach {
                pointer.next = it
                pointer = it!!
            }
            pointer.next = current
        }

        return root.next
    }
}
