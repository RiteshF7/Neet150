package org.trex.kotlin.tree

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    var current = root
    if (p != null && q != null) {
        while (current != null) {
            current = if (q.data > current.data && p.data > current.data) {
                current.right
            } else if (q.data < current.data && p.data < current.data) {
                current.left
            } else {
                return current
            }

        }
    }

    return null
}

fun main() {
    val root = TreeNode(6).apply {
        left = TreeNode(2).apply {
            left = TreeNode(0)
            right = TreeNode(4).apply {
                left = TreeNode(3)
                right = TreeNode(5)
            }
        }
        right = TreeNode(8).apply {
            left = TreeNode(7)
            right = TreeNode(9)
        }
    }

    println("LCA of 2 and 4 is: " + lowestCommonAncestor(root, root.left, root.left?.right)?.data)
    println(
        "LCA of 3 and 5 is: " + lowestCommonAncestor(
            root,
            root.left?.right?.left,
            root.left?.right?.right
        )?.data
    )
    println(
        "LCA of 7 and 9 is: " + lowestCommonAncestor(
            root,
            root.right?.left,
            root.right?.right
        )?.data
    )
}