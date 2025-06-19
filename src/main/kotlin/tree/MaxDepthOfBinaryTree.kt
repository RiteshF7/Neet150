package org.trex.kotlin.tree

import org.trex.kotlin.BaseExecutor

fun main() {
    MaxDepthOfBinaryTree().printOutput()
}

class MaxDepthOfBinaryTree : BaseExecutor<TreeNode?, Int>() {
    override val input: TreeNode?
        get() = TreeNode(1, TreeNode(2), TreeNode(3, left = TreeNode(4)))

    override fun execute(): Int {
        var root = input
        return maxDepth(root)
    }


    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val leftDepth = maxDepth(root.left)
        val rightDepth = maxDepth(root.right)
        return 1 + maxOf(leftDepth, rightDepth)
    }
}