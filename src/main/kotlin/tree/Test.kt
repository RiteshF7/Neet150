package org.trex.kotlin.tree


fun isValidBST(node: TreeNode?, lower: Int?, upper: Int?): Boolean {
    if (node == null) {
        println("Reached a null node -> returning true")
        return true
    }

    val value = node.data
    println("Visiting node $value with bounds lower=$lower and upper=$upper")

    if (lower != null && value <= lower) {
        println("Node $value is not > lower bound $lower -> returning false")
        return false
    }
    if (upper != null && value >= upper) {
        println("Node $value is not < upper bound $upper -> returning false")
        return false
    }

    println("Recursively checking right subtree of $value")
    if (!isValidBST(node.right, value, upper)) {
        return false
    }

    println("Recursively checking left subtree of $value")
    if (!isValidBST(node.left, lower, value)) {
        return false
    }

    println("Node $value satisfies BST conditions -> returning true")
    return true
}

fun main() {
    // Invalid BST:
    //          50
    //        /    \
    //      30      70
    //     /  \    /  \
    //   20   40  60   90
    //             \
    //              45   <-- Invalid (should be > 50)

    val tree = TreeNode(
        50,
        left = TreeNode(
            30,
            left = TreeNode(20),
            right = TreeNode(40)
        ),
        right = TreeNode(
            70,
            left = TreeNode(
                60,
                right = TreeNode(45) // ❌ Invalid here
            ),
            right = TreeNode(90)
        )
    )

    println("Starting validation for large INVALID BST...\n")
    val result = isValidBST(tree, null, null)
    println("\nFinal result: The tree is ${if (result) "a valid BST" else "not a valid BST"}")
}