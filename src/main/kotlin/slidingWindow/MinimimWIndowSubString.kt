package org.trex.kotlin.slidingWindow

import org.trex.kotlin.BaseExecutor

fun main() {
    MinimumWindowSubString().printOutput()
}

data class MinimimWindowSubStringInput(val s1: String, val s2: String)

class MinimumWindowSubString : BaseExecutor<MinimimWindowSubStringInput, String>() {
    override val input: MinimimWindowSubStringInput
        get() = MinimimWindowSubStringInput("ADOBECODEBANC", "ABC")

    private val s = input.s1
    private val t = input.s2


    override fun execute(): String {

        if (s.isEmpty() || t.isEmpty()) return ""
        val needMap = HashMap<Char, Int>()
        val haveMap = HashMap<Char, Int>()
        var minLen = Int.MAX_VALUE
        var have = 0
        for (char in t) {
            needMap[char] = needMap.getOrDefault(char, 0) + 1
        }
        val need = needMap.size

        val res = Array(size = 2) { -1 }
        var l = 0
        for (r in s.indices) {

            //updating have char
            val char = s[r]
            if (char in needMap) {
                haveMap[char] = haveMap.getOrDefault(char, 0) + 1
                if (haveMap[char]!! == needMap[char]!!) {
                    have++
                }
            }

            //poping until have !=need
            while (have == need) {
                val len = (r - l) + 1
                if (len < minLen) {
                    minLen = len
                    res[0] = l
                    res[1] = r
                }

                val lChar = s[l]
                if (lChar in needMap) {
                    haveMap[lChar] = haveMap[lChar]!! - 1
                    if (haveMap[lChar]!! < needMap[lChar]!!) {
                        have--
                    }
                }
                l++

            }


        }

        return if (res[0] == -1) "" else s.substring(res[0]..res[1])
    }


}