package org.trex.kotlin.slidingWindow

import org.trex.kotlin.BaseExecutor
import kotlin.math.max

fun main() {
    LongestRepeatingCharaterReplacement().printOutput()
}

class LongestRepeatingCharaterReplacement : BaseExecutor<String, Int>() {
    override val input: String
        get() = "AABACCCBBAACBBCC"

    override fun execute(): Int {
        val count = HashMap<Char, Int>()
        val k = 4
        var maxf = 0
        var l = 0
        var result = 0

        for (i in input.indices) {
            val current = input[i]
            count[current] = count.getOrDefault(current, 0) + 1
            maxf = max(maxf, count[current]!!)  // Track the highest frequency character

            while ((i - l + 1) - maxf > k) {  // Ensure window condition holds
                count[input[l]] = count[input[l]]!! - 1  // Reduce count, not remove
                l++  // Correctly move window forward
            }

            result = max(result, i - l + 1)  // Update max length found
        }
        return result
    }

}