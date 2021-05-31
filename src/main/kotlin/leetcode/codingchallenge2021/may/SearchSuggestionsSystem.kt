package leetcode.codingchallenge2021.may

object SearchSuggestionsSystem {
    fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
        val ans = mutableListOf<List<String>>()
        val ordered = products.sortedArray()
        var prefix = ""

        searchWord.forEach { c ->
            prefix += c
            var left = 0
            var right = ordered.lastIndex

            while (right >= left) {
                val middle = (left + right) / 2
                if (ordered[middle] == prefix) {
                    left = middle
                    break
                }
                else if (ordered[middle] < prefix) left = middle + 1
                else right = middle - 1
            }
            ans += (left..left + 2)
                .mapNotNull { if (it > ordered.lastIndex) null else ordered[it] }
                .filter { it.startsWith(prefix) }
        }

        return ans
    }
}

//    fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
//        val ans = mutableListOf<List<String>>()
//
//        val trie = Trie(*products)
//        var current: TrieNode? = trie.children[searchWord[0]]
//        var prefix = "${searchWord[0]}"
//        ans += current?.toList()?.map { it }?.take(3)?.toList() ?: emptyList()
//
//        searchWord.drop(1).forEach { c ->
//            current = current?.children?.get(c)
//            ans += current?.toList()?.map { "$prefix$it" }?.take(3)?.toList() ?: emptyList()
//            prefix = "$prefix$c"
//        }
//
//        return ans
//    }
//}
//
//abstract class Trie {
//    val children = HashMap<Char, TrieNode>()
//
//    fun add(word: String) {
//        if (word.isEmpty()) return
//
//        if (children[word[0]] == null) children[word[0]] = TrieNode(word[0])
//        var node = children[word[0]]!!
//        if (word.length == 1) node.isTerminate = true
//        word.withIndex().drop(1).forEach { (i, c) ->
//            if (node.children[c] == null) node.children[c] = TrieNode(c)
//            node = node.children[c]!!
//            if (i == word.lastIndex) node.isTerminate = true
//        }
//    }
//
//    abstract fun toList(): Sequence<String>
//
//    companion object {
//        operator fun invoke() = TrieRoot()
//
//        operator fun invoke(vararg words: String): Trie {
//            val root = TrieRoot()
//            words.forEach {
//                root.add(it)
//            }
//            return root
//        }
//    }
//}
//
//class TrieRoot : Trie() {
//    override fun toList(): Sequence<String> =
//        ('a'..'z').asSequence().mapNotNull { children[it] }.flatMap { it.toList() }
//}
//
//data class TrieNode(val value: Char) : Trie() {
//    var isTerminate: Boolean = false
//
//    override fun toList(): Sequence<String> =
//        ('a'..'z').mapNotNull { children[it] }.let { children ->
//            if (children.isEmpty()) sequenceOf(value.toString())
//            else (if (isTerminate) sequenceOf(value.toString()) else emptySequence()) +
//                    children.asSequence().flatMap { child -> child.toList().map { "$value$it" } }
//        }
//}
