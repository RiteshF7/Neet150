package org.trex.kotlin.binarySearch

import org.trex.kotlin.BaseExecutor


fun main() {
    IterativeBinarySearch().printOutput()
}

class IterativeBinarySearch : BaseExecutor<IntArray, Int>() {
    override val input: IntArray
        get() = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)

    private val nums = input
    private val element = 7
    override fun execute(): Int {
        var low = 0
        var high = nums.lastIndex
        while (low <= high) {
            val mid = low + (high - low) / 2
            if (element > nums[mid]) {
                low = mid
            } else if (element < nums[mid]) {
                high = mid
            } else {
                return mid
            }
        }
        return -1
    }
}