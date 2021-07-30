package leetcode.codingchallenge2021.july

import java.util.Stack

class MapSum {
    val root = Trie()

    fun insert(key: String, value: Int) = root.insert(key, value)

    fun sum(prefix: String): Int = when (val root = root.find(prefix)) {
        null -> 0
        else -> {
            var sum = 0
            val stack = Stack<Trie>()
            stack += root
            while (stack.isNotEmpty()) {
                val node = stack.pop()
                if (node.isTerm()) sum += node.value()
                node.next.forEach { (_, n) ->
                    stack += n
                }
            }
            sum
        }
    }

    class Trie(private var value: Int = 0, private var isTerm: Boolean = false) {
        val next: HashMap<Char, Trie> = hashMapOf()

        fun isTerm(): Boolean = isTerm
        fun value(): Int = value

        fun insert(key: String, v: Int) {
            var current = this
            key.forEach { c ->
                when (val node = current.next[c]) {
                    null -> {
                        val n = Trie()
                        current.next += c to n
                        current = n
                    }
                    else -> current = node
                }
            }
            current.value = v
            current.isTerm = true
        }

        fun find(prefix: String): Trie? =
            if (prefix.isEmpty()) this
            else when (val n = next[prefix.first()]) {
                null -> null
                else -> n.find(prefix.drop(1))
            }
    }
}
