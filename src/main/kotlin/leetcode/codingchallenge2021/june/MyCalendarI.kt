package leetcode.codingchallenge2021.june

class MyCalendarI {
    data class Range(val start: Int, val end: Int)

    private val intervalList = mutableListOf<Range>()

    fun book(start: Int, end: Int): Boolean =
        (intervalList.isEmpty() || intervalList.all { range -> (end <= range.start || range.end <= start) }).also {
            if (it) intervalList += Range(start, end)
        }
}