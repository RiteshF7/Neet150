package org.trex.kotlin.binarySearchTree

import org.trex.kotlin.BaseExecutor
import kotlin.math.min


//[3,4,5,6,1,2]
fun main() {
    FindMinInRotatedArray().printOutput()
}

class FindMinInRotatedArray : BaseExecutor<IntArray, Int>() {
    override val input: IntArray
        get() = intArrayOf(3,4,5,6,7,8)

    override fun execute(): Int {
        val nums = input
        var low = 0
        var high = nums.size - 1
        if (nums[low]<nums[high]) return nums[low]
        while (low < high) {
            val mid = low + (high - low) / 2
            if (nums[mid] >= nums[low]) {
                low = mid + 1
            } else {
                high = mid
            }
        }

        return nums[low]
    }
}