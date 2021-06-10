package leetcode.codingchallenge2021.june

import java.util.*

class MyCalendarI {

    private val intervals = TreeMap<Int, Int>()

    fun book(start: Int, end: Int): Boolean {
        val prev = intervals.floorEntry(start)
        val next = intervals.ceilingEntry(start)
        return if ((prev == null || prev.end() <= start) && (next == null || end <= next.start())) {
            intervals += start to end
            true
        } else false
    }
}
typealias Range = Map.Entry<Int, Int>

fun Range.start() = this.key
fun Range.end() = this.value
