package org.trex.kotlin.heapAndPriorityQueue

import java.util.PriorityQueue


fun main() {


    val medianFinder = MinMaxHeap()
    medianFinder.add(5) // arr = [5]
    medianFinder.findMedian().also { println("expected: 5.0 result :: $it") } // return 5.0
    medianFinder.add(10) // arr = [5, 10]
    medianFinder.findMedian().also { println("expected 7.5 result :: $it") } // return 7.5
    medianFinder.add(1) // arr = [1, 5, 10]
    medianFinder.findMedian().also { println("expected 5.0 result :: $it") } // return 5.0


    medianFinder.printBoth()

}

class MinMaxHeap {
    private val minHeap = PriorityQueue<Int>()
    private val maxHeap = PriorityQueue<Int>(compareByDescending { it })

    fun add(element: Int) {
        if (maxHeap.isEmpty() || element <= maxHeap.peek()) {
            maxHeap.add(element)
        } else {
            minHeap.add(element)
        }


        if (minHeap.isNotEmpty()) {
            if (maxHeap.peek() > minHeap.peek()) {
                minHeap.add(maxHeap.poll())
            }
        }


        if (maxHeap.size > minHeap.size + 1) {
            minHeap.add(maxHeap.poll())
        } else if (minHeap.size > maxHeap.size) {
            maxHeap.add(minHeap.poll())
        }


    }


    private fun isBothHeapEqual() = minHeap.size == maxHeap.size

    fun findMedian(): Double {
        if (isBothHeapEqual()) return (minHeap.peek() + maxHeap.peek()) / 2.0
        if (maxHeap.size > minHeap.size) return maxHeap.peek().toDouble()
        else return minHeap.peek().toDouble()
    }

    fun printBoth() {
        println("Printing max heap ::")
        maxHeap.forEach { println("$it,") }
        println("Printing min heap::")
        minHeap.forEach { println("$it,") }


    }

}