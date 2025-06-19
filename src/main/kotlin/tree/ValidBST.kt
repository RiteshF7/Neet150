package org.trex.kotlin.tree

import org.trex.kotlin.BaseExecutor

fun main() {
    ValidBST().printOutput()
}

class ValidBST : BaseExecutor<TreeNode?, Boolean>() {

    private val testCase = 2 // Change this to test different inputs

    override val input: TreeNode?
        get() {
            return when (val case = testCase) {
                1 -> TreeNode(10, TreeNode(5), TreeNode(10))               // Valid BST
                2 -> TreeNode(5, TreeNode(1), TreeNode(4).apply {        // Invalid BST
                    left = TreeNode(3)
                    right = TreeNode(6)
                })

                3 -> TreeNode(1)                                          // Single node
                4 -> null                                                 // Empty tree
                5 -> TreeNode(10, TreeNode(5), TreeNode(15).apply {      // Invalid BST
                    left = TreeNode(6)
                    right = TreeNode(20)
                })

                6 -> TreeNode(
                    8, TreeNode(4, TreeNode(2), TreeNode(6)),  // Valid full BST
                    TreeNode(12, TreeNode(10), TreeNode(14))
                )

                7 -> TreeNode(3, TreeNode(3), TreeNode(4))               // Duplicate left value
                else -> null
            }
        }


    override fun execute(): Boolean {
        val root = input
//        isInBound(5, 5, 10).also { println(it) }
        return isValidBST(root, Int.MIN_VALUE, Int.MAX_VALUE)
    }


    private fun validate(node: TreeNode?, lower: Int, upper: Int): Boolean {
        if (node == null) return true
        val value = node.data
        if (value <= lower || value >= upper) return false
        return validate(node.right, node.data, upper) && validate(node.left, lower, node.data)
    }


    private fun isInBound(num: Int, l: Int, u: Int): Boolean {
        return num in l..u
    }

    private fun isInBound2(num: Int, l: Int, u: Int): Boolean {
        return num <= l || num >= u
    }


}