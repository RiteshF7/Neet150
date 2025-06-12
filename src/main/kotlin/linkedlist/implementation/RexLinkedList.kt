package org.trex.kotlin.linkedlist.implementation

data class Node<T>(val value: T, var nextNode: Node<T>?)

class RexLinkedList<T>() {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    private fun isEmpty(): Boolean = size == 0

    override fun toString(): String {
        return if (isEmpty()) {
            "List is empty"
        } else {
            val stringBuilder = StringBuilder()
            var node = head
            while (node != null) {
                stringBuilder.append(node.value)
                if (node.nextNode != null) stringBuilder.append("->")
                node = node.nextNode
            }
            return stringBuilder.toString()
        }
    }

    fun firstNode():Node<T>?{
        return head
    }

    fun push(value: T): RexLinkedList<T> = apply {
        head = Node(value, head)
        if (tail == null) tail = head
        size++
    }

    fun removeFirst() {
        if (head == null) {
            tail = null
            return
        }
        head = head?.nextNode
        size--
    }

    fun removeLast() {
        if (head == null) return
        if (head == tail) {
            head = null
            tail = null
            size--
        }
        var node = head
        while (node?.nextNode?.nextNode !=null) {
            node = node.nextNode
        }
        node?.nextNode = null
        tail = node
        size--
    }

    fun printElements() {
        var node: Node<T>? = head
        val listString = StringBuilder()
        while (node != null) {
            listString.append(node.value)
            node = node.nextNode
            if (node != null) listString.append("->")
        }
        println(listString)
    }


}