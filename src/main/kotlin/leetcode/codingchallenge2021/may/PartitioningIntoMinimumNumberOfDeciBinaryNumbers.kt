package leetcode.codingchallenge2021.may

object PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    fun minPartitions(n: String): Int = n.map { it.digitToInt() }.maxOf { it }
}
