package org.trex.kotlin.tree

class BinaryTree {
    private var root: TreeNode? = null


    fun insert(value: Int) {
        root = insertRec(root, value)
    }

    fun insertAll(list: List<Int>) {
        list.forEach {
            insert(it)
        }
    }

    fun printRoot() {
        println(root)
    }

    private fun insertRec(node: TreeNode?, value: Int): TreeNode {
        if (node == null) return TreeNode(value)
        if (value < node.data) {
            node.left = insertRec(node.left, value)
        } else {
            node.right = insertRec(node.right, value)
        }

        return node
    }


}