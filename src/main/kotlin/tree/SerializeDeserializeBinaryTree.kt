package org.trex.kotlin.tree

fun main() {
    val root = TreeUtils.createSimpleTree()
    val codec = Codec()
    val enc = codec.serialize(root)
    val out = codec.deserialize(enc)
    TreeUtils.printTree(out)

}

class Codec {

    fun serialize(root: TreeNode?): String {
        val builder = StringBuilder()
        serializeHelper(root, builder)
        return builder.toString()
    }

    private fun serializeHelper(node: TreeNode?, builder: StringBuilder) {
        if (node == null) return

        builder.append("${node.data},")

        val leftExists = serializeAndFlag(node.left, builder)
        if (!leftExists) builder.append("N,")

        val rightExists = serializeAndFlag(node.right, builder)
        if (!rightExists) builder.append("N,")
    }

    private fun serializeAndFlag(node: TreeNode?, builder: StringBuilder): Boolean {
        if (node == null) return false
        serializeHelper(node, builder)
        return true
    }

    fun deserialize(s: String): TreeNode? {
        val values = s.split(",").filter { it.isNotEmpty() }
        val parsed = values.map {
            if (it == "N") null else it.toInt()
        }
        var i = 0

        fun dfs(): TreeNode? {
            if (i >= parsed.size) return null
            val value = parsed[i++]
            if (value == null) return null
            val node = TreeNode(value)
            node.left = dfs()
            node.right = dfs()
            return node
        }

        return dfs()
    }
}