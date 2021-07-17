package leetcode.codingchallenge2021.july

class ThreeEqualPartsSolution {
    fun threeEqualParts(arr: IntArray): IntArray {
        val countOne = arr.count { it == 1 }
        if (countOne == 0) return intArrayOf(0, arr.lastIndex)
        if (countOne % NUM_OF_PARTS != 0) return intArrayOf(-1, -1)

        val x = countOne / NUM_OF_PARTS
        var first = arr.indexOf(1)
        var second = 0
        var third = 0
        var count = 0
        for (it in first..arr.lastIndex) {
            if (arr[it] == 1) {
                count++
                if (count == x + 1) second = it
                if (count == 2 * x + 1) {
                    third = it
                    break
                }
            }
        }

        while (third < arr.size && arr[first] == arr[second] && arr[second] == arr[third]) {
            first++
            second++
            third++
        }

        return if (third == arr.size) intArrayOf(first - 1, second) else intArrayOf(-1, -1)
    }

    companion object {
        const val NUM_OF_PARTS = 3
    }
}
