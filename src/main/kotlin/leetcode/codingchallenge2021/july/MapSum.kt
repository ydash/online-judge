package leetcode.codingchallenge2021.july

class MapSum {
    val map = hashMapOf<String, Int>()
    val root = Trie()

    fun insert(key: String, value: Int) {
        val delta = value - map.getOrDefault(key, 0)
        map += key to value
        root.insert(key, delta)
    }

    fun sum(prefix: String): Int = root.sum(prefix)

    class Trie {
        private val children: HashMap<Char, Trie> = hashMapOf()
        private var value: Int = 0

        private fun find(prefix: String): Trie? = find(this, prefix)

        fun insert(key: String, delta: Int) = insert(this, key, delta)

        fun sum(prefix: String): Int = this.find(prefix)?.value ?: 0

        companion object {
            private fun find(node: Trie, prefix: String): Trie? {
                var current = node
                for (c in prefix) {
                    current = current.children[c] ?: return null
                }
                return current
            }

            private fun insert(node: Trie, key: String, delta: Int) {
                var current = node
                key.forEach { c ->
                    current = current.children.getOrPut(c) { Trie() }
                    current.value += delta
                }
            }
        }
    }
}
