package leetcode.util

data class ListNode(var `val`: Int) {
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
