package org.trex.kotlin.arrayAndHashmap


/*
Products of Array Except Self
Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i].

Each product is guaranteed to fit in a 32-bit integer.

Follow-up: Could you solve it in
O(n)
O(n) time without using the division operation?

Example 1:

Input: nums = [1,2,4,6]

Output: [48,24,12,8]
Example 2:

Input: nums = [-1,0,1,2,3]

Output: [0,-6,0,0,0]*/

fun main() {
    val input = intArrayOf(1, 2, 4, 6)
    val result = ProductExceptSelf.execute(input)
    result.forEach { print("$it,") }
}

object ProductExceptSelf {
    fun execute(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { 1 }
        var prefix = 1

        for (i in nums.indices) {
            //to shift the index by one assign first in result
            result[i] *= prefix
            //calculating prefix for each after shifting index
            prefix *= nums[i]
        }
        var suffix = 1
        for (i in nums.indices.reversed()) {
            //now result of i contains the shifted prefix value
            result[i] *= suffix
            suffix *= nums[i]
        }

        return result
    }


}