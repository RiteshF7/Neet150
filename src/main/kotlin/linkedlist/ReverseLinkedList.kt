package org.trex.kotlin.linkedlist

import org.trex.kotlin.BaseExecutor
import org.trex.kotlin.linkedlist.implementation.Node
import org.trex.kotlin.linkedlist.implementation.RexLinkedList

fun main(){
    ReverseLinkedList().printOutput()
}

class ReverseLinkedList : BaseExecutor<Node<Int>?, Node<Int>?>() {

    private fun insertElementsAndGetHead(): Node<Int>? {
        val linkedList = RexLinkedList<Int>().push(0).push(1).push(2).push(3)
        return linkedList.firstNode()
    }

    override val input: Node<Int>?
        get() = insertElementsAndGetHead()

    override fun execute(): Node<Int>? {
        var current: Node<Int>? = input
        var prev: Node<Int>? = null
        while (current != null) {
            val next = current.nextNode
            current.nextNode = prev
            prev = current
            current = next
        }
        println(prev?.value)
        return prev
    }

}