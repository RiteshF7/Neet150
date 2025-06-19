package org.trex.kotlin.tree

import org.trex.kotlin.BaseExecutor

class IsSubTree : BaseExecutor<TreeNode?, Boolean>() {
    override val input: TreeNode?
        get() = TreeNode(
            1,
            left = TreeNode(
                2,
                left = TreeNode(4), TreeNode(5)
            ),
            right = TreeNode(3)
        )
    val treeOne = input
    val treeTwo = TreeNode(2, TreeNode(4), TreeNode(5))
    override fun execute(): Boolean {
        return false
    }

    fun isSubTree(t1: TreeNode?, t2: TreeNode?): Boolean {
        if (t2 == null) return true
        if (t1 == null) return false
        if (isSameTree(t1, t2)) return true
        return isSubTree(t1.left, t2.left) || isSubTree(t1.right, t2.right)
    }

    private fun isSameTree(n1: TreeNode?, n2: TreeNode?): Boolean {
        if (n1 == null && n2 == null) return true
        if (n1 == null || n2 == null) return false
        if (n1.data != n2.data) return false
        return isSameTree(n1.left, n2.left) && isSameTree(n1.right, n2.right)
    }
}