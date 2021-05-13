package leetcode.codingchallenge2021.may

object AmbiguousCoordinate {
    fun ambiguousCoordinates(s: String): List<String> {
        val numStr = s.substring(1, s.length - 1)
        val buffer = mutableListOf<String>()
        (1 until numStr.length).forEach() { i ->
            val x = numStr.substring(0, i)
            val y = numStr.substring(i, numStr.length)
            insertDecimalPoint(x).forEach { x ->
                insertDecimalPoint(y).forEach { y ->
                    buffer += "($x, $y)"
                }
            }
        }
        return buffer
    }

    fun insertDecimalPoint(str: String): List<String> {
        val buffer = mutableListOf<String>()
        if (str.length == 1 || str[0] != '0') buffer += str

        (1 until str.length).forEach { i ->
            val integer = str.substring(0, i)
            val fractional = str.substring(i, str.length)
            if (fractional.last() != '0') {
                if (i < 2 || integer[0] != '0') buffer += "$integer.$fractional"
            }
        }
        return buffer
    }
}
