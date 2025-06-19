package org.trex.kotlin.tree

import org.trex.kotlin.BaseExecutor

fun main() {
    InvertBinaryTree().printOutput()
}

class InvertBinaryTree : BaseExecutor<TreeNode?, TreeNode?>() {

    override val input: TreeNode
        get() = TreeNode(
            1,
            TreeNode(2, TreeNode(4), TreeNode(5)),
            TreeNode(3, TreeNode(6), TreeNode(7))
        )

    override fun execute(): TreeNode? {
        val root = invertTree(input)
        return root
    }

    private fun invertTree(node: TreeNode?): TreeNode? {
        if (node == null) return null
        val left = invertTree(node.left)
        val right = invertTree(node.right)
        node.left = right
        node.right = left
        return node
    }

    fun isSameTree(rootOne: TreeNode?, rootTwo: TreeNode?): Boolean {
        if (rootOne == null || rootTwo == null || rootOne.data != rootTwo.data)
            isSameTree(rootOne?.right, rootTwo?.right)
            isSameTree(rootOne?.left, rootTwo?.left)
        return false
    }


}