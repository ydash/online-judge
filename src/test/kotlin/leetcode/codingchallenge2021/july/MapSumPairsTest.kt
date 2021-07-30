package leetcode.codingchallenge2021.july

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MapSumPairsTest : StringSpec({
    "test1" {
        val obj = MapSum()
        obj.insert("apple", 3)
        obj.sum("ap") shouldBe 3
        obj.insert("app", 2)
        obj.sum("ap") shouldBe 5
        obj.insert("apple", 5)
        obj.sum("ap") shouldBe 7
        obj.insert("apple", 1)
        obj.sum("ap") shouldBe 3

        obj.insert("answer", 42)
        obj.sum("answer") shouldBe 42
        obj.sum("a") shouldBe 45
    }

    "test2" {
        val obj = MapSum()
        obj.insert("a", 3)
        obj.sum("ap") shouldBe 0
        obj.insert("b", 2)
        obj.sum("a") shouldBe 3
    }

    "test3" {
        MapSum().apply {
            insert("aa", 3)
            insert("aa", 2)
            sum("aa") shouldBe 2
            insert("aaa", 3)
            insert("aewfwaefjeoawefjwoeajfowajfoewajfoawefjeowajfowaj", 111)
            insert("bb", 143)
            insert("cc", 144)
            insert("aew", 145)
            sum("aew") shouldBe 256
        }
    }

    "test4" {
        MapSum().apply {
            insert("appled", 2)
            sum("ap") shouldBe 2
            insert("apple", 3)
            insert("apple", 2)
            sum("a") shouldBe 4
        }
    }
})
