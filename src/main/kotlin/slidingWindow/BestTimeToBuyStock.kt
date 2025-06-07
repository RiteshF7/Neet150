package org.trex.kotlin.slidingWindow

import org.trex.kotlin.BaseExecutor

class BestTimeToBuyStock:BaseExecutor<IntArray,Int>() {
    override val input: IntArray
        get() = intArrayOf(10,1,5,6,7,1)

    override fun execute(): Int {
        var maxProfit = 0
        var l=0
        var r=1
        while (l<r){
            val currentProfit = input[l]-input[r]
            if (currentProfit > maxProfit){

            }
        }
        return -1
    }
}