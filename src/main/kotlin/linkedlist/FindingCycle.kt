package org.trex.kotlin.linkedlist

import org.trex.kotlin.linkedlist.implementation.ListNode


class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
            if (fast == slow) return true
        }
        return false // No cycle found
    }
}

// Definition for singly-linked list node

// Test case function
fun main() {
    // Creating a linked list with a cycle: 1 -> 2 -> 3 -> 4 -> (back to 2)
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node2 // Creating cycle

    val solution = Solution()
    println("Has Cycle? " + solution.hasCycle(node1)) // Expected: true

    // Creating a linked list without a cycle: 1 -> 2 -> 3 -> 4 -> null
    val nodeA = ListNode(1)
    val nodeB = ListNode(2)
    val nodeC = ListNode(3)
    val nodeD = ListNode(4)

    nodeA.next = nodeB
    nodeB.next = nodeC
    nodeC.next = nodeD

    println("Has Cycle? " + solution.hasCycle(nodeA)) // Expected: false
}