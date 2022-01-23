package google

class SumOfElementsInBinaryTreeWithinRange {

    fun getSum(root: Node?, start: Int, end: Int): Int {

        var sum = 0

        root ?: return 0

        val itself = if (root.value < start || root.value > end) 0 else root.value
        
        sum += itself + getSum(root.left, start, end) + getSum(root.right, start, end)

        return sum
    }


}

fun main() {

    val sumOfElementsInBinaryTreeWithinRange = SumOfElementsInBinaryTreeWithinRange()


    val root = Node(
        5,
        Node(
            3,
            Node(2),
            Node(4)
        ),
        Node(
            8,
            Node(6),
            Node(10)
        )
    )

    println(sumOfElementsInBinaryTreeWithinRange.getSum(null, 4, 9))
    println(sumOfElementsInBinaryTreeWithinRange.getSum(root, 4, 9))

}