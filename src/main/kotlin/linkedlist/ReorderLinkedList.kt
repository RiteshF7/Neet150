package org.trex.kotlin.linkedlist

import org.trex.kotlin.linkedlist.implementation.ListNode


class ReorderLinkedList {
    fun reorderList(head: ListNode?) {
        var fast = head
        var slow = head
        while (fast?.next?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
        }
        var midNode = slow?.next
        slow?.next=null
        var prev: ListNode? = null
        while (midNode != null) {
            val next = midNode.next
            midNode.next = prev
            prev = midNode
            midNode = next
        }

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

        nodeOne?.next = null


    }

}

// Test Cases
fun main() {
    fun printList(head: ListNode?) {
        var node = head
        while (node != null) {
            print("${node.value} -> ")
            node = node.next
        }
        println("null")
    }

    // Example 1: Input [2,4,6,8]
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    println("Before reordering:")
    printList(node1)

    val reorder = ReorderLinkedList()
    reorder.reorderList(node1)

    println("After reordering:")
    printList(node1)

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

    println("Before reordering:")
    printList(nodeA)

    reorder.reorderList(nodeA)

    println("After reordering:")
    printList(nodeA)
}