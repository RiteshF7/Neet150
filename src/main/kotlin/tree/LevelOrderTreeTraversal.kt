package org.trex.kotlin.tree

import java.util.LinkedList
import java.util.Queue


class BinaryTreeLevelOrderTraversal {

    //BFS
    private fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        val nodeQueue: Queue<TreeNode?> = LinkedList()
        nodeQueue.add(root)
        val result = mutableListOf<List<Int>>()

        while (nodeQueue.isNotEmpty()) {
            val level = mutableListOf<Int>()
            val n = nodeQueue.size
            repeat(n) {
                val node = nodeQueue.poll()
                node?.run {
                    level.add(node.data)
                    left?.let { nodeQueue.add(it) }
                    right?.let { nodeQueue.add(it) }
                }

            }

            result.add(level)

        }
        return result
    }

    fun runExamples() {
        // Example 1: [1,2,3,4,5,6,7]
        val root1 = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4)
                right = TreeNode(5)
            }
            right = TreeNode(3).apply {
                left = TreeNode(6)
                right = TreeNode(7)
            }
        }

        // Example 2: [1]
        val root2 = TreeNode(1)

        // Example 3: []
        val root3: TreeNode? = null

        println("Example 1 Output: ${levelOrder(root1)}")
        println("Example 2 Output: ${levelOrder(root2)}")
        println("Example 3 Output: ${levelOrder(root3)}")
    }
}

fun main() {
    BinaryTreeLevelOrderTraversal().runExamples()
}