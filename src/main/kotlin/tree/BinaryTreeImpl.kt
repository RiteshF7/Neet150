package org.trex.kotlin.tree


fun main() {
    BinaryTreeImpl().createATree()
}

class BinaryTreeImpl {

    val tree = BinaryTree()

    fun createATree() {
        val binaryTreeValues = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        tree.insertAll(binaryTreeValues)
        tree.printRoot()
    }
}