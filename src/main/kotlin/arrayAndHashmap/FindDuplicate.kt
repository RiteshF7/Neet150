package org.trex.kotlin.arrayAndHashmap

import org.trex.kotlin.arrayAndHashmap.DuplicateFinder.findDuplicate

/*
* Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.

Example 1:

Input: nums = [1, 2, 3, 3]

Output: true

Example 2:

Input: nums = [1, 2, 3, 4]

Output: false
* */
fun main() {
    val result = findDuplicate(intArrayOf(1, 2, 3, 4, 4, 5, 6, 7))
    println(result)

}

object DuplicateFinder {

    fun findDuplicate(nums: IntArray): Boolean {

        val map = hashMapOf<Int, Int>()

        for (i in nums.indices) {
            println(nums[i])
            map[nums[i]] = map.getOrDefault(nums[i], 0) + 1
            if (map[nums[i]]!! > 1) return true
        }
        return false
    }
}
