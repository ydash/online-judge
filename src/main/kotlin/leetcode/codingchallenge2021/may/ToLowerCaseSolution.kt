package leetcode.codingchallenge2021.may

const val GAP_BETWEEN_UPPERCASE_AND_LOWERCASE = 32

object ToLowerCaseSolution {
    fun toLowerCase(s: String): String =
        s.map { if (it in 'A'..'Z') it + GAP_BETWEEN_UPPERCASE_AND_LOWERCASE else it }.joinToString("")
}
