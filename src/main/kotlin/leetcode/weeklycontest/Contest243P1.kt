package leetcode.weeklycontest

object Contest243P1 {
    fun isSumEqual(firstWord: String, secondWord: String, targetWord: String): Boolean {
        return firstWord.toNum() + secondWord.toNum() == targetWord.toNum()
    }

    private fun String.toNum(): Int = String(this.map { it - 49 }.toCharArray()).toInt()
}