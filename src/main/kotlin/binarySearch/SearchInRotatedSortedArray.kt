package org.trex.kotlin.binarySearch

import org.trex.kotlin.BaseExecutor

fun main() {
    SearchInRotatedSortedArray().printOutput()
}

class SearchInRotatedSortedArray : BaseExecutor<IntArray, Int>() {

    val target = 0
    override val input: IntArray
        get() = intArrayOf(6, 7, 8, 0,1, 2, 3, 4, 5)


    override fun execute(): Int {
        val nums = input
        var low = 0
        var high = nums.size - 1
        while (low <= high) {
            val mid = low + (high - low) / 2
            if (target == nums[mid]) return mid
            //left is sorted
            if (nums[low] <= nums[mid]) {
                //target exists in the left portion
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1
                }

                //target exists in other half
                else {
                    low = mid + 1
                }
            }

            // right is sorted
            else {

                //target exists in this portion
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1
                }
                //target exists in other half
                else {
                    high = mid - 1
                }
            }


        }
        return -1
    }

}