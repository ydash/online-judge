package leetcode.codingchallenge2021.may

object ValidNumber {
    fun isNumber(s: String): Boolean = when (val i = s.indexOfFirst { it == 'e' || it == 'E' }) {
        0, s.length - 1 -> false
        -1 -> isDecimal(s) || isInteger(s)
        else -> {
            val front = s.substring(0, i)
            val back = s.substring(i + 1)
            (isDecimal(front) || isInteger(front)) && isInteger(back)
        }
    }

    fun isInteger(str: String): Boolean {
        return when (val s = dropSign(str)) {
            "" -> false
            else -> isUnsignedInteger(s)
        }
    }

    private fun isUnsignedInteger(str: String): Boolean = str.all { ('0'..'9').contains(it) }

    fun isDecimal(str: String): Boolean = isUnsignedDecimal(dropSign(str))

    private fun isUnsignedDecimal(str: String): Boolean = when (val i = str.indexOf('.')) {
        -1 -> false
        else -> {
            if (str.length == 1) false
            else isUnsignedInteger(str.substring(0, i)) && isUnsignedInteger(str.substring(i + 1))
        }
    }

    private fun dropSign(str: String): String = when (str[0]) {
        '+', '-' -> str.drop(1)
        else -> str
    }
}
