package leetcode.codingchallenge2021.july

class IsomorphicStrings {
    fun isIsomorphic(s: String, t: String): Boolean {
        val s2t = IntArray(SIZE) { -1 }
        val t2s = IntArray(SIZE) { -1 }

        for (i in s.indices) {
            val x = s[i].code
            val y = t[i].code

            when {
                s2t[x] == -1 && t2s[y] == -1 -> {
                    s2t[x] = y
                    t2s[y] = x
                }
                s2t[x] != y || t2s[y] != x ->
                    return false
            }
        }
        return true
    }

    companion object {
        const val SIZE = 128
    }
}
