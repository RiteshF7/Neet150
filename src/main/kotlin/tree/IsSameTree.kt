package org.trex.kotlin.tree

import org.trex.kotlin.BaseExecutor

fun main() {
    IsSameTree().printOutput()
}

class IsSameTree : BaseExecutor<TreeNode?, Boolean>() {
    override val input: TreeNode?
        get() = TreeNode(1, TreeNode(2), TreeNode(3))
    private val treeOne = input
    private val treeTwo = TreeNode(1, TreeNode(2), TreeNode(3))

    override fun execute(): Boolean {
        val result = isSameTree(treeOne, treeTwo)
        return result
    }

    fun isSameTree(n1: TreeNode?, n2: TreeNode?): Boolean {
        if (n1 == null && n2 == null) return true
        if (n1 == null || n2 == null) return false
        if (n1.data != n2.data) return false
        return isSameTree(n1.left, n2.left) && isSameTree(n1.right, n2.right)
    }


}