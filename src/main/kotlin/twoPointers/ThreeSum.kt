package org.trex.kotlin.twoPointers

import org.trex.kotlin.BaseExecutor

fun main() {
    ThreeSum().printOutput()
}

class ThreeSum : BaseExecutor<IntArray, MutableList<IntArray>>() {
    override val input: IntArray
        get() = intArrayOf(-2,0,2,-2,0,2)

    override fun execute(): MutableList<IntArray> {
        val result: MutableList<IntArray> = mutableListOf()
        val nums = input.toMutableList().sorted()
        for (i in nums.indices) {
            val current = nums[i]
            if (i > 0 && current == nums[i - 1]) continue
            var left = i + 1
            var right = nums.size - 1

            while (left < right) {
                val threeSum = nums[i] + nums[left] + nums[right]
                if (threeSum > 0) {
                    right--
                } else if (threeSum < 0) {
                    left++
                } else {
                    result.add(intArrayOf(nums[i], nums[left], nums[right]))
                    left++
                    if (nums[left] == nums[left - 1] && left < right) {
                        left++
                    }
                }

            }
        }

        return result
    }

}