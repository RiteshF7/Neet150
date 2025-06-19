package org.trex.kotlin.tree

object TreeUtils {

    fun printTree(root: TreeNode?) {
        if (root == null) {
            println("Empty tree")
            return
        }

        val queue: ArrayDeque<Pair<TreeNode?, Int>> = ArrayDeque()
        queue.addLast(Pair(root, 0))
        var currentLevel = 0
        val levelBuilder = StringBuilder()
        val dataListBuilder = StringBuilder()

        while (queue.isNotEmpty()) {
            val (node, level) = queue.removeFirst()
            if (level != currentLevel) {
                println("Level $currentLevel: $levelBuilder")
                levelBuilder.clear()
                currentLevel = level
            }

            if (node == null) {
                levelBuilder.append("null ")
            } else {
                levelBuilder.append("${node.data} ")
                queue.addLast(Pair(node.left, level + 1))
                queue.addLast(Pair(node.right, level + 1))
            }
            if (node?.data != null) {
                dataListBuilder.append("${node.data},")
            }

        }

        if (levelBuilder.isNotEmpty()) {
            println("Level $currentLevel: $levelBuilder")
        }

        if (dataListBuilder.isNotEmpty()) {
            println("Data :[$dataListBuilder]")
        }

    }

}