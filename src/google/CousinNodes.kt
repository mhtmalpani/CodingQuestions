package google

class CousinNodes {

    private var elementLevel: Int = -1
    private var elementParent: Node? = null

    fun getCousins(root: Node?, element: Int): List<Int> {

        //Find the level for this element
        val (elementLevel, elementParent) = getLevel(root, null, element, 1)

        this.elementLevel = elementLevel
        this.elementParent = elementParent

        //Find the cousins i.e. elements in the same level but not the same parent
        val cousins = mutableListOf<Int>()

        computeCousins(root, null, 1, cousins)

        return cousins
    }

    private fun getLevel(node: Node?, parent: Node?, element: Int, level: Int): Pair<Int, Node?> {

        node ?: return Pair(-1, parent)

        if (node.value == element) return Pair(level, parent)

        val (leftSide, parentLeft) = getLevel(node.left, node, element, level + 1)
        val (rightSide, parentRight) = getLevel(node.right, node, element, level + 1)

        if (leftSide != -1) return Pair(leftSide, parentLeft)
        if (rightSide != -1) return Pair(rightSide, parentRight)

        return Pair(-1, parent)
    }

    private fun computeCousins(node: Node?, parent: Node?, level: Int, cousins: MutableList<Int>) {

        node ?: return

        if (level == elementLevel && parent != elementParent)
            cousins.add(node.value)

        computeCousins(node.left, node, level + 1, cousins)
        computeCousins(node.right, node, level + 1, cousins)
    }

}

data class Node(
    val value: Int,
    val left: Node? = null,
    val right: Node? = null
)

fun main() {
    val cousinNodes = CousinNodes()

    val root = Node(
        1,
        Node(
            2,
            Node(
                4,
                Node(7),
                Node(8)
            ),
            Node(
                5,
                Node(9),
                Node(10)
            )
        ),
        Node(
            3,
            Node(
                6,
                Node(11),
                Node(12)
            )
        )
    )

    val element = 8

    val cousins = cousinNodes.getCousins(root, element)

    println("Cousins for $element:")
    cousins.forEach {
        println(it)
    }
}