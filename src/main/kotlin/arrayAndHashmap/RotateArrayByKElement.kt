package org.trex.kotlin.arrayAndHashmap

import org.trex.kotlin.BaseExecutor

fun main() {
    RotateArrayByKElement().printOutput()
}

class RotateArrayByKElement : BaseExecutor<IntArray, IntArray>() {
    override val input: IntArray
        get() = intArrayOf(1, 2, 3, 4, 5)

    private val k = 7

    override fun execute(): IntArray {
        val nums = input
        rotateArray(nums[0], 0, nums)
        return nums
    }

    var i = 0
    private fun rotateArray(prevTemp: Int, prevShift: Int, nums: IntArray) {
        if (i > nums.size) return
        var nextShift = prevShift + k
        if (nextShift > nums.lastIndex) nextShift %= nums.size
        val nextTemp = nums[nextShift]
        nums[nextShift] = prevTemp
        i++
        rotateArray(nextTemp, nextShift, nums)
    }

}