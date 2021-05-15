package leetcode.codingchallenge2021.may

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class ValidNumberTest : StringSpec({

    "Given a string s, return true if s is a valid number." {
        listOf(
            "2",
            "0089",
            "-0.1",
            "+3.14",
            "4.",
            "-.9",
            "2e10",
            "-90E3",
            "3e+7",
            "+6e-1",
            "53.5e93",
            "-123.456e789"
        ).forAll { ValidNumber.isNumber(it) shouldBe true }

        listOf(
            "abc",
            "1a",
            "1e",
            "e3",
            "99e2.5",
            "--6",
            "-+3",
            "95a54e53",
            ".",
            "4e+"
        ).forAll { ValidNumber.isNumber(it) shouldBe false }
    }

    "Given a string, return true if it is a integer." {
        forAll(
            row("2", true),
            row("0089", true),
            row("-0.1", false),
            row("+3.14", false),
            row("4.", false),
            row("-.9", false),
            row("2e10", false),
            row("-90E3", false),
            row("3e+7", false),
            row("+6e-1", false),
            row("53.5e93", false),
            row("-123.456e789", false),
            row(".", false),
            row("+", false)
        ) { input, output ->
            ValidNumber.isInteger(input) shouldBe output
        }
    }

    "Given a string, return true if it is a decimal." {
        forAll(
            row("2", false),
            row("0089", false),
            row("-0.1", true),
            row("+3.14", true),
            row("4.", true),
            row("-.9", true),
            row("2e10", false),
            row("-90E3", false),
            row("3e+7", false),
            row("+6e-1", false),
            row("53.5e93", false),
            row("-123.456e789", false),
            row(".", false),
            row("4e+", false),
            row("+", false)
        ) { input, output ->
            ValidNumber.isDecimal(input) shouldBe output
        }
    }

})
