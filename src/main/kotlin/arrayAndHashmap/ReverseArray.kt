package org.trex.kotlin.arrayAndHashmap

import org.trex.kotlin.BaseExecutor

fun main(){
    ReverseArray().printOutput()
}

class ReverseArray : BaseExecutor<IntArray, IntArray>() {
    override val input: IntArray
        get() = intArrayOf(1,2,3,4,5)
        private val k = 2
        private val nums = input

    override fun execute(): IntArray {
        val n = nums.size
        val shift = k%n
        reverse(0,n-1)
        reverse(0,shift-1)
        reverse(shift,n-1)
        return nums
    }

    fun reverse(start:Int,end:Int){
        var i = start
        var j = end
        while (i<j){
            val temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
            i++
            j--
        }
    }
}