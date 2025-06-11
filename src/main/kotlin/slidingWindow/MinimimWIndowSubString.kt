package org.trex.kotlin.slidingWindow

import org.trex.kotlin.BaseExecutor
import kotlin.math.min

fun main() {
    MinimumWindowSubString().printOutput()
}

data class MinimimWindowSubStringInput(val s1: String, val s2: String)

class MinimumWindowSubString : BaseExecutor<MinimimWindowSubStringInput, String>() {
    override val input: MinimimWindowSubStringInput
        get() = MinimimWindowSubStringInput("OUZODYXAZV", "XYZ")

    private val s = input.s1
    private val t = input.s2


    override fun execute(): String {

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
            val char = s[r]
            if (needMap.contains(char)) {
                haveMap[char] = haveMap.getOrDefault(char, 0) + 1
                if (haveMap[char]!! == needMap[char]!!) {
                    have++
                }
                if (need == have) {
                    val len = (r - l) + 1
                    minLen = min(minLen, len)
                    if (minLen == len) {
                        res[0] = l
                        res[1] = r
                    }

                    while (need == have) {
                        l++
                        if (needMap.contains(s[l])) {
                            haveMap[s[l]] = haveMap[s[l]]!! - 1
                            have--
                        }

                    }

                }
            }


        }




        return s.substring(l, res[1] + 1)
    }


}