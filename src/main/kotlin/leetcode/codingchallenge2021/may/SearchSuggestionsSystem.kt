package leetcode.codingchallenge2021.may

object SearchSuggestionsSystem {
    fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
        var candidates = products.sorted()
        val ans = mutableListOf<List<String>>()

        searchWord.withIndex().forEach { (i, c) ->
            candidates = candidates.filter { word -> word[i] == c }
            ans += candidates.take(3)
        }

        return ans
    }
}