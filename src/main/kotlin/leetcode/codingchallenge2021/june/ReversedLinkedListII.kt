package leetcode.codingchallenge2021.june

object ReversedLinkedListII {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (left == right) return head

        var tmp: ListNode? = null
        var tmpRightEnd: ListNode? = null
        var beforeLeft: ListNode? = null

        var i = 1
        var current: ListNode? = head
        var prev: ListNode? = null
        loop@ while (current != null) {
            when {
                i == left -> {
                    beforeLeft = prev
                    tmp = ListNode(current.`val`)
                    tmpRightEnd = tmp
                }
                i == right -> {
                    tmp = ListNode(current.`val`).apply { this.next = tmp }
                    tmpRightEnd!!.next = current.next
                    break@loop
                }
                tmp != null -> {
                    tmp = ListNode(current.`val`).apply { this.next = tmp }
                }
            }
            prev = current
            current = current.next
            ++i
        }

        return if (beforeLeft != null) {
            beforeLeft.next = tmp
            head
        } else tmp
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    fun toList(): List<Int> {
        val lst = mutableListOf<Int>()
        var current: ListNode? = this
        while (current != null) {
            lst += current.`val`
            current = current.next
        }
        return lst
    }

    companion object {
        fun ofList(list: List<Int>): ListNode? =
            if (list.isEmpty()) null
            else ListNode(list[0]).apply { next = ofList(list.drop(1)) }
    }
}
