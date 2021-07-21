package leetcode.codingchallenge2021.july

class PushDominoesSolution {
    fun pushDominoes(dominoes: String): String {
        val answer = StringBuilder()
        var i = 0
        var count = 0
        var prev: Push = Push.Not
        while (i < dominoes.length) {
            when (val current = Push.valueOf(dominoes[i])) {
                Push.Left -> {
                    behaviorWhenPushLeft(prev, count, answer)
                    answer.append(current.value)
                    prev = Push.Not
                    count = 0
                }
                Push.Right -> {
                    behaviorWhenPushRight(prev, count, answer)
                    answer.append(current.value)
                    prev = Push.Right
                    count = 0
                }
                Push.Not -> count++
            }
            i++
        }

        when (prev) {
            Push.Right -> repeat(count) { answer.append(prev.value) }
            else -> repeat(count) { answer.append(Push.Not.value) }
        }
        return answer.toString()
    }

    private fun behaviorWhenPushLeft(prev: Push, count: Int, buffer: StringBuilder) = when (prev) {
        Push.Right -> {
            val x = count / 2
            repeat(x) { buffer.append(Push.Right.value) }
            if (count % 2 != 0) buffer.append(Push.Not.value)
            repeat(x) { buffer.append(Push.Left.value) }
        }
        else -> repeat(count) { buffer.append(Push.Left.value) }
    }

    private fun behaviorWhenPushRight(prev: Push, count: Int, buffer: StringBuilder) = when (prev) {
        Push.Right -> repeat(count) { buffer.append(Push.Right.value) }
        else -> repeat(count) { buffer.append(Push.Not.value) }
    }

    sealed class Push {
        abstract val value: Char

        object Left : Push() {
            override val value = 'L'
        }

        object Right : Push() {
            override val value = 'R'
        }

        object Not : Push() {
            override val value = '.'
        }

        companion object {
            fun valueOf(push: Char): Push = when (push) {
                'L' -> Left
                'R' -> Right
                else -> Not
            }
        }
    }
}
