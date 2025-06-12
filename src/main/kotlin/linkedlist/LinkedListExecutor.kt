package org.trex.kotlin.linkedlist

import org.trex.kotlin.linkedlist.implementation.RexLinkedList

fun main(){
    val myLinkedList = RexLinkedList<Int>()
    myLinkedList.push(1)
    myLinkedList.push(2)
    myLinkedList.push(5)
    myLinkedList.removeLast()
    myLinkedList.printElements()
}
