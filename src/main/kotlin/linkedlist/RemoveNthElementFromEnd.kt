package org.trex.kotlin.linkedlist

import org.trex.kotlin.linkedlist.implementation.ListNode

class RemoveNthFromEnd {
    /**
     * Removes the nth node from the end of the linked list and returns the modified head.
     */
//    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
//        var right = head
//        var left = head
//        var size = n + 1
//        while (n > 0 && right != null) {
//            right = right.next
//            size--
//        }
//
//        var tail: ListNode? = null
//        while (left != null && right != null) {
//            tail = right
//            right = right!!.next
//            left = left.next
//        }
//        left?.next = tail
//        return head
//    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var right = dummy
        var left = dummy

        // Move right pointer `n` steps ahead
        for (i in 0 until n) {
            right = right.next ?: return head // If `n` is larger than the list size
        }

        // Move both pointers until right reaches end
        while (right.next != null) {
            right = right.next!!
            left = left.next!!
        }

        // Remove the nth node
        left.next = left.next?.next

        return dummy.next // Return updated head
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
     * Initializes test cases and runs removal function
     */
    fun runTestCase(head: ListNode?, n: Int) {
        println("Before removing nth node (n = $n):")
        printList(head)
        val result = RemoveNthFromEnd().removeNthFromEnd(head, n)
        println("After removing nth node:")
        printList(result)
        println("------")
    }

    // Example 1: Input [1,2,3,4], n = 2
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
    val node6 = ListNode(6)
    val node7 = ListNode(7)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    node6.next = node7

    runTestCase(node1, 4)

    // Example 2: Input [5], n = 1
    val nodeA = ListNode(5)
    runTestCase(nodeA, 1)

    // Example 3: Input [1,2], n = 2
    val nodeX = ListNode(1)
    val nodeY = ListNode(2)
    nodeX.next = nodeY

    runTestCase(nodeX, 2)
}