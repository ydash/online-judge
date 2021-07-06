package leetcode.codingchallenge2021.july

class ReduceArraySizeToTheHalf {
    fun minSetSize(arr: IntArray): Int {
        val length = arr.size
        val freq = IntArray(size = 100001)
        val numOfFreq = IntArray(arr.size + 1)
        arr.forEach { n -> freq[n] += 1 }
        freq.forEach { c -> if (c != 0) numOfFreq[c] += 1 }

        var ans = 0
        var sum = 0
        for (n in arr.size downTo 1) {
            repeat(numOfFreq[n]) {
                sum += n
                ++ans
                if (sum + sum >= length) return ans
            }
        }

        return ans
    }
}
