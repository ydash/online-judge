package leetcode.codingchallenge2021.july

class ReduceArraySizeToTheHalf {
    fun minSetSize(arr: IntArray): Int {
        val length = arr.size
        val count = IntArray(size = 100001)
        arr.forEach { n -> count[n] += 1 }

        var ans = 0
        var sum = 0
        for (n in count.indices.sortedByDescending { count[it] }) {
            sum += count[n]
            ++ans
            if (sum + sum >= length) break
        }

        return ans
    }
}
