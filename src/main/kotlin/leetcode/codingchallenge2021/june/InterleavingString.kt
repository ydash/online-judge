package leetcode.codingchallenge2021.may

object InterleavingString {

    fun isInterleave(s1: String, s2: String, s3: String): Boolean =
        if (s1.length + s2.length != s3.length) false
        else {
            val m = s1.length
            val n = s2.length
            val current = BooleanArray(n + 1)
            val archive = BooleanArray(n + 1)

            for (i in 0..m) {
                for (j in 0..n) {
                    when {
                        i == 0 && j == 0 -> current[0] = true
                        i == 0 -> if (s2[j - 1] == s3[j - 1]) current[j] = current[j - 1]
                        j == 0 -> if (s1[i - 1] == s3[i - 1]) current[j] = archive[j]
                        s1[i - 1] == s3[i + j - 1] && s2[j - 1] != s3[i + j - 1] -> current[j] = archive[j]
                        s1[i - 1] != s3[i + j - 1] && s2[j - 1] == s3[i + j - 1] -> current[j] = current[j - 1]
                        s1[i - 1] == s3[i + j - 1] && s2[j - 1] == s3[i + j - 1] ->
                            current[j] = archive[j] || current[j - 1]
                    }
                }
                archive.indices.forEach { archive[it] = current[it] }
                current.indices.forEach { current[it] = false }
            }
            archive[n]
        }
}