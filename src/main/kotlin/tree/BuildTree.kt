package org.trex.kotlin.tree

fun main() {
    BuildTree().exec()
}

class BuildTree {
    val preOrder = mutableListOf<Int>(1, 2, 3, 4)
    val inOrder = mutableListOf<Int>(2, 1, 3, 4)
    val root = TreeNode()


    val current = root
    fun exec() {
        val output = withHashmap(preOrder, inOrder)
        println(output)
//        test()
    }

    private fun buildTree(preOrder: List<Int>, inOrder: List<Int>): TreeNode? {
        if (preOrder.isEmpty() || inOrder.isEmpty()) return null
        val node = TreeNode(preOrder[0])
        val mid = inOrder.indexOf(preOrder[0])
        node.left = buildTree(
            preOrder.slice(1 until 1 + mid),
            inOrder.slice(0 until mid)
        )
        node.right = buildTree(
            preOrder.slice(mid + 1 until preOrder.size),
            inOrder.slice(mid + 1 until inOrder.size)

        )

        return node
    }

    fun withHashmap(preOrder: List<Int>, inOrder: List<Int>): TreeNode? {
        var prevIndex = 0
        val inOrderMap = inOrder.withIndex().associate { (index, value) -> value to index }

        fun dfs(left: Int, right: Int): TreeNode? {
            if (left > right) return null
            val preOrderValue = preOrder[prevIndex++]
            val node = TreeNode(preOrderValue)
            val mid = inOrderMap[preOrderValue]!!
            node.left = dfs(left, mid - 1)
            node.right = dfs(mid + 1, right)
            return node
        }

        return dfs(0, inOrder.lastIndex)
    }

    fun test() {
        val list = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
        list.slice(1..1).forEach { print(it) }

    }


}