package org.trex.kotlin.slidingWindow

import org.trex.kotlin.BaseExecutor
import kotlin.math.max

fun main() {
    LongSubStringWithoutRepeat().printOutput()
}

class LongSubStringWithoutRepeat : BaseExecutor<String, Int>() {
    override val input: String
        get() = "abcbadbd"

    override fun execute(): Int {
        val strs = input
        val strSet = HashSet<Char>()
        var l = 0
        var result = 0
        for (i in strs.indices) {
            while (strSet.contains(strs[i])) {
                strSet.remove(strs[l])
                l++
            }
            strSet.add(strs[i])
            result = max(result, (i - l) + 1)
        }

        return result
    }

}