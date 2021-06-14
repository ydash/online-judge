package leetcode.codingchallenge2021.june

object MaximumUnitsTruck {
    fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
        boxTypes.sortBy { -it[1] }
        var ans = 0
        var count = 0
        for ((num, unit) in boxTypes) {
            if (count >= truckSize) break
            val n = if (count + num <= truckSize) num else truckSize - count
            count += n
            ans += n * unit
        }
        return ans
    }
}
