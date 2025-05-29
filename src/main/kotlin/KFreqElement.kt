package org.trex.kotlin

fun main() {
    val result = KFreqElement.findKFreqElement(
        intArrayOf(
            1, 2
        ), 2
    )

    result.forEach { println(it) }
}


object KFreqElement {
    fun findKFreqElement(nums: IntArray, k: Int): List<Int> {
        val iMap = hashMapOf<Int, Int>()
        val bucket = Array(size = nums.size + 1) { mutableListOf<Int>() }
        for (num in nums) {
            iMap[num] = iMap.getOrDefault(num, 0) + 1
        }

        for ((num, freq) in iMap) {
            bucket[freq].add(num)
        }

        val result = mutableListOf<Int>()

        for (i in bucket.indices.reversed()) {
            if (bucket[i].size == 0) continue
            for (num in bucket[i]) {
                result.add(num)
                if (result.size == k) return result
            }
        }
        return listOf()
    }


}