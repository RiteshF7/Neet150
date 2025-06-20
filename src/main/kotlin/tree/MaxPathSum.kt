package org.trex.kotlin.tree

import org.trex.kotlin.BaseExecutor
import org.trex.kotlin.tree.TreeUtils.createTree
import kotlin.math.max

fun main() {
    val res = MaxPathSum().printOutput()
}


class MaxPathSum : BaseExecutor<TreeNode, Int>() {
    override val input: TreeNode
        get() = createTree()

    private var maxSum = Int.MIN_VALUE
    override fun execute(): Int {
        val root = input
        findMaxSum(root)
        return maxSum
    }


    fun simpleDfs(node: TreeNode?): TreeNode? {
        if (node == null) return null
        val left = simpleDfs(node.left)
        val right = simpleDfs(node.right)
        println(" root is :: ${node.data}  left is :: ${left} right is  :: ${right}")
        println()
        return node
    }

    fun findMaxSum(node: TreeNode?): Int {
        if (node == null) return 0

        val leftSum = max(0, findMaxSum(node.left))
        val rightSum = max(0, findMaxSum(node.right))
        maxSum = max(maxSum, node.data + leftSum + rightSum)
        return node.data + max(rightSum, leftSum)
    }



}