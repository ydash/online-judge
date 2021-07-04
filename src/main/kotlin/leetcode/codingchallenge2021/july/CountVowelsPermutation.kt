package leetcode.codingchallenge2021.july

class CountVowelsPermutation {

    fun countVowelPermutation(n: Int): Int {
        val prev = IntArray(NUM_OF_VOWELS)
        val current = IntArray(NUM_OF_VOWELS)
        (0 until NUM_OF_VOWELS).forEach { current[it] = 1 }

        repeat(n - 1) {
            (0 until NUM_OF_VOWELS).forEach {
                prev[it] = current[it]
                current[it] = 0
            }

            current[INDEX_A] = prev[INDEX_E]
            current[INDEX_E] = (prev[INDEX_A] + prev[INDEX_I]) % MOD
            current[INDEX_I] = (((prev[INDEX_A] + prev[INDEX_E]) % MOD + prev[INDEX_O]) % MOD + prev[INDEX_U]) % MOD
            current[INDEX_O] = (prev[INDEX_I] + prev[INDEX_U]) % MOD
            current[INDEX_U] = prev[INDEX_A]
        }

        return current.fold(0) { acc, i -> (acc + i) % MOD }
    }

    companion object {
        const val MOD = 1000000007

        const val NUM_OF_VOWELS = 5
        const val INDEX_A = 0
        const val INDEX_E = 1
        const val INDEX_I = 2
        const val INDEX_O = 3
        const val INDEX_U = 4
    }
}