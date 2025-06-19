package org.trex.kotlin.tree

import org.trex.kotlin.BaseExecutor

fun main() {
    KthSmallestElement(4).printOutput()
}

class KthSmallestElement(val k: Int) : BaseExecutor<TreeNode?, Int>() {
    private val result = mutableListOf<Int>()

    override val input: TreeNode?
        get() = TreeNode(
            4,
            left = TreeNode(
                3,
                left = TreeNode(2)
            ),
            right = TreeNode(5)
        )

    override fun execute(): Int {
        var len = 0
        val stack = ArrayDeque<TreeNode>()
        var current = input
        while (current != null || stack.isNotEmpty()) {
            while (current != null) {
                stack.addFirst(current)
                current = current.left
            }
            current = stack.removeFirst()
            len += 1
            if (len == k) return current.data
            current = current.right
        }
        return -1
    }

//    override fun execute(): Int {
//        iterate(input)
//        return result[k-1]
//    }


//    override fun execute(): Int {
//        val queue: Queue<TreeNode> = LinkedList()
//        val root = input
//        val sortedList = mutableListOf<Int>()
//        queue.add(root)
//        while (queue.isNotEmpty()) {
//            val n = queue.size
//            repeat(n) {
//                queue.poll()?.run {
//                    left?.let { sortedList.add(it.data) }
//                    sortedList.add(data)
//                    right?.let { sortedList.add(it.data) }
//                    queue.add(left)
//                    queue.add(right)
//                }
//            }
//        }
//
//        println()
//        sortedList.forEach { print("$it,"); }
//        println()
//        return -1
//    }


    fun iterate(node: TreeNode?): TreeNode? {
        if (node == null) return null
        iterate(node.left)
        result.add(node.data)
        iterate(node.right)
        return node
    }
}