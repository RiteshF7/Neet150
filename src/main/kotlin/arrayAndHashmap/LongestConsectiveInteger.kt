package org.trex.kotlin.arrayAndHashmap

import org.trex.kotlin.BaseExecutor
import kotlin.math.max

/*
## Longest Consecutive Sequence

Given an array of integers nums, return the length of the longest consecutive sequence of elements that can be formed.

A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element. The elements do not have to be consecutive in the original array.

You must write an algorithm that runs in O(n) time.

Example 1:

Input: nums = [2,20,4,10,3,4,5]

Output: 4
Explanation: The longest consecutive sequence is [2, 3, 4, 5].

Example 2:

Input: nums = [0,3,2,5,4,6,1,1]

Output: 7
*/
fun main() {
    LongestConsectiveInteger().printOutput()
}

class LongestConsectiveInteger() : BaseExecutor<IntArray, Int>() {
    override val input: IntArray
        get() = intArrayOf(2, 20, 4, 10, 3, 4, 5)

    override fun execute(): Int {
        val numSet = input.toHashSet()
        var longest = 0

        for (n in input) {
            if (!numSet.contains(n - 1)) {
                var len = 1
                while (numSet.contains(n + len)) {
                    len += 1
                }
                longest = max(longest, len)
            }


        }
        return longest
    }

}



