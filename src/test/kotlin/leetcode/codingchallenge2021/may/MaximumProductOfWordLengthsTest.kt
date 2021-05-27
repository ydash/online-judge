package leetcode.codingchallenge2021.may

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class MaximumProductOfWordLengthsTest : StringSpec({
    "Given a string array, return the maximum product value of two words which don't share common letters." {
        forAll(
            row(arrayOf("abcw", "baz", "foo", "bar", "xtfn", "abcdef"), 16),
            row(arrayOf("a", "ab", "abc", "d", "cd", "bcd", "abcd"), 4),
            row(arrayOf("a", "aa", "aaa", "aaaa"), 0),
            row(
                arrayOf(
                    "edadc", "ebbfe", "aacdde", "dfe", "cb", "fddddff", "fabca", "adccac", "ece", "ccaf", "feba", "bcb",
                    "edadc", "aea", "bacb", "acefa", "fcebffd", "dfeebca", "bedcbaa", "deaccc", "abedc", "dadff", "eef",
                    "ddebbb", "abecab", "cd", "abdeee", "eedce", "deef", "dceaddd", "ced", "fbbf", "ba", "eefeda", "fb",
                    "cddc", "adafbf", "dded", "aadbf", "caefbaf", "ccebf", "dbb", "ee", "dadcecc", "ddbcabb", "afeaa",
                    "ec", "aad", "efde", "cbcda", "cdbdafd", "cddc", "ecaaa", "ae", "cfc", "bccac", "cdcc", "abbbf",
                    "fcdface", "ddbcdc", "bfebb", "daed", "bc", "dc", "ecdfc", "eeb", "bb", "dad", "caecb", "fbe",
                    "bbbc", "cacea", "dbc", "fbe", "bcfffbd", "aeda", "cff", "ddfc", "ea", "bdfd", "ccb", "cb", "ae",
                    "ceabefa", "dcea", "cbaed", "bfedf", "fa", "ccd", "fece", "bceef", "acabca", "dafa", "fdeec", "dac",
                    "cae", "adeeadb", "ecacc", "acfe", "de"
                ),
                42
            )
        ) { input, output ->
            MaximumProductOfWordLengths.maxProduct(input) shouldBe output
        }
    }
})
