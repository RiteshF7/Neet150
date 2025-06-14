package org.trex.kotlin.linkedlist

import org.trex.kotlin.BaseExecutor
import org.trex.kotlin.linkedlist.implementation.Node
import org.trex.kotlin.linkedlist.implementation.RexLinkedList

fun main() {
    MergeTwoSortedList().printOutput()
}

class MergeTwoSortedList : BaseExecutor<Node<Int>?, Node<Int>?>() {
    private val linkedList1 = RexLinkedList<Int>().push(4).push(2).push(1)
    private val linkedList2 = RexLinkedList<Int>().push(5).push(3).push(1)

    private val node1 = linkedList1.firstNode()
    private val node2 = linkedList2.firstNode()

    override val input: Node<Int>?
        get() = null

    override fun execute(): Node<Int>? {
        merger(node1, node2)
        return null
    }

    fun merger(n1: Node<Int>?, n2: Node<Int>?): Node<Int>? {

        val dummyNode: Node<Int>? = Node(0, null)
        var currentNode = dummyNode
        var firstNode = n1
        var secondNode = n2
        while (firstNode != null && secondNode != null) {
            if (firstNode.value < secondNode.value) {
                currentNode?.nextNode = firstNode
                firstNode = firstNode.nextNode
            } else {
                currentNode?.nextNode = secondNode
                secondNode = secondNode.nextNode
            }
            currentNode = currentNode?.nextNode
        }

        currentNode?.nextNode = firstNode ?: secondNode
        return dummyNode?.nextNode

    }


    fun merge(left: Node<Int>, element: Node<Int>, right: Node<Int>) {
        left.nextNode = element
        element.nextNode = right
    }

}