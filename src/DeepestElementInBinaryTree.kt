class DeepestElementInBinaryTree {

    private var deepestElement: Int = -1
    private var deepestLevel: Int = -1

    fun getDeepestElement(root: Node?): Int {
        traversal(root, 1)
        return deepestElement
    }

    private fun traversal(node: Node?, level: Int) {
        node ?: return

        if (level > deepestLevel) {
            deepestElement = node.value
            deepestLevel = level
        }

        traversal(node.left, level + 1)
        traversal(node.right, level + 1)
    }

}

data class Node(
    val value: Int,
    var left: Node? = null,
    var right: Node? = null,
)

fun main() {

    val deepestElementInBinaryTree = DeepestElementInBinaryTree()

    val root = Node(
        10,
        Node(
            20,
            Node(30),
            Node(
                50,
                Node(60)
            )
        ),
        Node(40)
    )

    println(deepestElementInBinaryTree.getDeepestElement(root))

}