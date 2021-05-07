package aoj

import java.io.PrintWriter

object Template {
    val read = { readLine() ?: throw RuntimeException("failed to read data.") }
    val readPair =
        { read().split(" ").map { it.toInt() }.let { Pair(it[0], it[1]) } }
    val readInt = { read().toInt() }

    @JvmStatic
    fun main(args: Array<String>) {
        val pw = PrintWriter(System.out)

        val (n, m) = readPair()
        repeat(m) {
            val (a, b) = readPair()
        }

        pw.flush()
    }
}

