package org.trex.kotlin.twoPointers

import org.trex.kotlin.BaseExecutor

/*Container With Most Water
You are given an integer array heights where heights[i] represents the height of the
i
t
h
i
th
  bar.

You may choose any two bars to form a container. Return the maximum amount of water a container can store.

Example 1:



Input: height = [1,7,2,5,4,7,3,6]

Output: 36
Example 2:

Input: height = [2,2,2]

Output: 4*/

fun main() {
    ContainerWithMostWater().printOutput()
}

class ContainerWithMostWater : BaseExecutor<IntArray, Int>() {
    override val input: IntArray
        get() = intArrayOf(1, 7, 2, 5, 4, 7, 3, 6)

    override fun execute(): Int {
        var left = 0
        var right = input.size - 1
        var largest = 0
        while (left < right) {
            val len = right - left
            val height = minOf(input[right] , input[left])
            largest = maxOf(largest, len * height)
            if (input[left] < input[right]) {
                left++
            } else {
                right--
            }

        }
        return largest
    }


}