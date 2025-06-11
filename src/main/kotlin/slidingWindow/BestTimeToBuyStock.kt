package org.trex.kotlin.slidingWindow

import org.trex.kotlin.BaseExecutor
import kotlin.math.max


fun main() {
    BestTimeToBuyStock().printOutput()
}

class BestTimeToBuyStock : BaseExecutor<IntArray, Int>() {
    override val input: IntArray
        get() = intArrayOf(10, 1, 5, 6, 7, 1)

    override fun execute(): Int {
        var l = 0
        var r = 1
        var max = 0
        while (r < input.size) {
            if (input[r] < input[l]) {
                l=r
            } else {
                val profit = input[r] - input[l]
                max = max(max, profit)
            }
            r++
        }

        return max
    }
}