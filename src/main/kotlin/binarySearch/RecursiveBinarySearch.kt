package org.trex.kotlin.binarySearch

import org.trex.kotlin.BaseExecutor

fun main() {
    RecursiveBinarySearch().printOutput()
}

class RecursiveBinarySearch : BaseExecutor<IntArray, Int>() {
    override val input: IntArray
        get() = intArrayOf(1, 2, 3, 4, 5)
    val nums = input
    val element = 5
    override fun execute(): Int {

        return searchElement(0, nums.lastIndex, nums, element)
    }

    fun searchElement(low: Int, high: Int, nums: IntArray, element: Int): Int {
        if (low <= high) {
            val mid = low + (high - low) / 2

            if (element == nums[mid]) return mid

            if (element > nums[mid]) return searchElement(mid + 1, high, nums, element)

            return searchElement(low, mid - 1, nums, element)

        }
        return -1
    }
}