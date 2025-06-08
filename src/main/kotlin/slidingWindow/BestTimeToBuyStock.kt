package org.trex.kotlin.slidingWindow

import org.trex.kotlin.BaseExecutor


fun main() {
    BestTimeToBuyStock().printOutput()
}

class BestTimeToBuyStock : BaseExecutor<IntArray, Int>() {
    override val input: IntArray
        get() = intArrayOf(10, 1, 5, 6, 7, 1)

    override fun execute(): Int {
        var l = 0
        var r = 1
//        while (l < input.size && r < input.size) {
//            print("$l,")
//            println()
//            println("$r")
//            l++
//            r++
//        }
        return -1
    }
}