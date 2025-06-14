package org.trex.kotlin.linkedlist

import org.trex.kotlin.linkedlist.implementation.ListNode

class ReorderLinkedList {

    /**
     * Reorders the given linked list to follow the pattern:
     * [0, n-1, 1, n-2, 2, n-3, ...]
     */
    fun reorderList(head: ListNode?) {
        if (head == null || head.next == null) return

        // Step 1: Find the middle node using fast and slow pointers
        var slow = head
        var fast = head
        while (fast?.next?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
        }

        // Step 2: Split the list into two halves
        var midNode = slow?.next
        slow?.next = null // Important to detach the first half

        // Step 3: Reverse the second half
        var prev: ListNode? = null
        while (midNode != null) {
            val next = midNode.next
            midNode.next = prev
            prev = midNode
            midNode = next
        }

        // Step 4: Merge both halves in alternating fashion
        var nodeOne = head
        var nodeTwo = prev
        while (nodeOne != null && nodeTwo != null) {
            val oneNext = nodeOne.next
            nodeOne.next = nodeTwo
            val twoNext = nodeTwo.next
            nodeTwo.next = oneNext
            nodeTwo = twoNext
            nodeOne = oneNext
        }

        // Step 5: Ensure last node points to null
        nodeOne?.next = null
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
     * Initializes test cases and runs reordering
     */
    fun runTestCase(head: ListNode?) {
        println("Before reordering:")
        printList(head)
        ReorderLinkedList().reorderList(head)
        println("After reordering:")
        printList(head)
        println("------")
    }

    // Example 1: Input [1,2,3,4,5]
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    runTestCase(node1)

    // Example 2: Input [2,4,6,8,10]
    val nodeA = ListNode(2)
    val nodeB = ListNode(4)
    val nodeC = ListNode(6)
    val nodeD = ListNode(8)
    val nodeE = ListNode(10)
    nodeA.next = nodeB
    nodeB.next = nodeC
    nodeC.next = nodeD
    nodeD.next = nodeE

    runTestCase(nodeA)
}