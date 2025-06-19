package org.trex.kotlin.tree

import org.trex.kotlin.BaseExecutor

fun main() {
    RecursionExample().printOutput()
}

class RecursionExample : BaseExecutor<TreeNode, Int>() {
    override val input: TreeNode
        get() = TreeNode(
            1,
            TreeNode(2), TreeNode(3, left = TreeNode(4))
        )

    override fun execute(): Int {
        val root = input
        val leftDepth = addLeftNodeRecursively(root);
//        val rightDepth = addRightNodeRecursively(root)
//        val valuesOnLeft = iterateLeftNodeRec(root)
//        iterateAllValuesOnRightTree(root)
//        iterateTree(root)
//        printRec(root)
        TreeUtils.printTree(root)
        val depth = printDepthRec(root)
        return depth
    }

    fun iterateTree(node: TreeNode?): TreeNode? {
        if (node == null) return null
        println("root: ${node.data}")
        val left = iterateTree(node.left)
        println("left: ${left?.data}")
        val right = iterateTree(node.right)
        println("right :${right?.right}")
        return node
    }

    fun printDepthRec(node: TreeNode?): Int {
        if (node == null) return 0
        val leftDepth = printDepthRec(node.left)
        val rightDepth = printDepthRec(node.right)
        return 1 + maxOf(leftDepth,rightDepth)
    }

    //root left right
    fun printRec(node: TreeNode?): TreeNode? {
        if (node == null) return null
        println("node data : ${node.data}")
        printRec(node.left)
        printRec(node.right)
        return node
    }

    fun iterateLeftNodeRec(node: TreeNode?): TreeNode? {
        if (node == null) return null
        println("some value on left is :: ${node.data}")
        val leftNode = iterateLeftNodeRec(node.left)
        return node
    }

    fun iterateAllValuesOnRightTree(node: TreeNode?): TreeNode? {
        if (node == null) return null
        println("some value on right :: ${node.data}")
        iterateAllValuesOnRightTree(node.right)
        return node
    }

    fun addLeftNodeRecursively(node: TreeNode?): Int {
        if (node == null) return 0
        val leftDepth = addLeftNodeRecursively(node.left)
        return 1 + leftDepth
    }

    fun addRightNodeRecursively(node: TreeNode?): Int {
        if (node == null) return 0
        return 1 + addLeftNodeRecursively(node.right)
    }
}