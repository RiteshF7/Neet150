package org.trex.kotlin.linkedlist

import org.trex.kotlin.linkedlist.implementation.ListNode

class MergeKSortedLists {
    /**
     * Merges k sorted linked lists into a single sorted linked list.
     */

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        var mergedList: ListNode? = null
        for (list in lists) {
            mergedList = mergeTwoSortedList(mergedList, list)
        }
        return mergedList
    }

    private fun mergeTwoSortedList(n1: ListNode?, n2: ListNode?): ListNode? {
        val dummyNode = ListNode(0, null)
        var current = dummyNode
        var nodeOne = n1
        var nodeTwo = n2
        while (nodeOne != null && nodeTwo != null) {
            if (nodeOne.value < nodeTwo.value) {
                current.next = nodeOne
                nodeOne = nodeOne.next
            } else {
                current.next = nodeTwo
                nodeTwo = nodeTwo.next
            }

            current = current.next!!
        }

        current.next = nodeTwo ?: nodeOne
        return dummyNode.next
    }

}

// Test Cases
fun main() {

    /**
     * Helper function to print a linked list
     */
    fun printList(head: ListNode?) {
        var node = head
        while (node != null) {
            print("${node.value} -> ")
            node = node.next
        }
        println("null")
    }

    /**
     * Initializes test cases and runs merge function
     */
    fun runTestCase(lists: Array<ListNode?>) {
        println("Before merging:")
        lists.forEach { printList(it) }
        val result = MergeKSortedLists().mergeKLists(lists)
        println("After merging:")
        printList(result)
        println("------")
    }

//    lists=[[1,2,3,4,5],[7,8,9,10],[11,12,13,14]]
    val l1 = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }

    val l2 = ListNode(7).apply {
        next = ListNode(8).apply {
            next = ListNode(9).apply {
                next = ListNode(10)
            }
        }
    }

    val l3 = ListNode(11).apply {
        next = ListNode(12).apply {
            next = ListNode(13).apply {
                next = ListNode(14)
            }
        }
    }

    val lists = arrayOf<ListNode?>(l1, l2, l3)

    runTestCase(lists)

    // Example 1: [[1,2,4], [1,3,5], [3,6]]
    val list1 = ListNode(1).apply { next = ListNode(2).apply { next = ListNode(4) } }
    val list2 = ListNode(1).apply { next = ListNode(3).apply { next = ListNode(5) } }
    val list3 = ListNode(3).apply { next = ListNode(6) }

    runTestCase(arrayOf(list1, list2, list3))

    // Example 2: Empty list []
    runTestCase(arrayOf())

    // Example 3: Single empty list [[]]
    runTestCase(arrayOf(null))
}