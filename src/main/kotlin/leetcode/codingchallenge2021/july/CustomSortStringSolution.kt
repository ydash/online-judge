package leetcode.codingchallenge2021.july

class CustomSortStringSolution {
    fun customSortString(order: String, str: String): String {
        val count = IntArray('z' - 'a' + 1)
        str.forEach { count[it - 'a'] += 1 }

        val buffer = StringBuilder()
        order.forEach { c ->
            repeat(count[c - 'a']) {
                buffer.append(c)
            }
            count[c - 'a'] = 0
        }
        count.indices.filterNot { count[it] == 0 }.forEach { i ->
            repeat(count[i]) {
                buffer.append('a' + i)
            }
        }

        return buffer.toString()
    }
}
