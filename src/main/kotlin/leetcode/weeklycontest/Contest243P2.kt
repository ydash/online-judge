package leetcode.weeklycontest

object Contest243P2 {
    fun maxValue(n: String, x: Int): String {
        val cx = (x + 48).toChar()
        var p = n.length
        when (n[0]) {
            '-' -> negLoop@ for (i in n.indices.drop(1)) {
                if (n[i] > cx) {
                    p = i
                    break@negLoop
                }
            }
            else -> posLoop@ for (i in n.indices) {
                if (n[i] < cx) {
                    p = i
                    break@posLoop
                }
            }
        }
        return "${n.substring(0, p)}$x${n.substring(p)}"
    }
}