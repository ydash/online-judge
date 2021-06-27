package leetcode.codingchallenge2021.june

object CandySolution {
    fun candy(ratings: IntArray): Int {
        val allocated = IntArray(ratings.size) { Int.MAX_VALUE }
        val orderedInd = ratings.indices.sortedBy { ratings[it] }

        orderedInd.forEach { i ->
            when {
                i == 0 -> {
                    if (ratings.size == 1 || ratings[i] <= ratings[i + 1]) allocated[i] = 1
                    else allocated[i] = allocated[i + 1] + 1
                }
                i == ratings.lastIndex -> {
                    if (ratings[i] <= ratings[i - 1]) allocated[i] = 1
                    else allocated[i] = allocated[i - 1] + 1
                }
                ratings[i] > ratings[i + 1] && ratings[i] > ratings[i - 1] -> {
                    allocated[i] = maxOf(allocated[i - 1], allocated[i + 1]) + 1
                }
                ratings[i] > ratings[i - 1] -> allocated[i] = allocated[i - 1] + 1
                ratings[i] > ratings[i + 1] -> allocated[i] = allocated[i + 1] + 1
                else -> allocated[i] = 1
            }
        }

        return allocated.sum()
    }
}