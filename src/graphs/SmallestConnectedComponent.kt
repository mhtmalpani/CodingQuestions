package graphs

class SmallestConnectedComponent {

    fun count(adjacencyMap: HashMap<Int, List<Int>>): Int {
        var smallestSize = Int.MAX_VALUE
        val visited: MutableSet<Int> = mutableSetOf()

        adjacencyMap.forEach {
            val size = explore(adjacencyMap, it.key, visited)
            if (size != 0 && size < smallestSize)
                smallestSize = size
        }

        return smallestSize
    }

    private fun explore(
        adjacencyMap: HashMap<Int, List<Int>>,
        node: Int,
        visited: MutableSet<Int>
    ): Int {

        if (visited.contains(node))
            return 0

        var size = 1

        visited.add(node)

        adjacencyMap[node]?.forEach {
            size += explore(adjacencyMap, it, visited)
        }

        return size
    }

}

fun main() {

    val adjacencyList1: HashMap<Int, List<Int>> = hashMapOf(
        1 to listOf(3),
        2 to listOf(3),
        3 to listOf(1, 2, 5, 7),
        4 to listOf(5),
        5 to listOf(3, 4, 6, 7),

        8 to listOf(9, 10, 11, 12),
        9 to listOf(8),
        10 to listOf(8, 12),
        11 to listOf(8),
        12 to listOf(8, 10),

        13 to listOf()
    )

    val adjacencyList2: HashMap<Int, List<Int>> = hashMapOf(
        1 to listOf(3),
        2 to listOf(3),
        3 to listOf(1, 2, 5, 7),
        4 to listOf(5),
        5 to listOf(3, 4, 6, 7),

        8 to listOf(9, 10),
        9 to listOf(8),
        10 to listOf(8)
    )

    val adjacencyList3: HashMap<Int, List<Int>> = hashMapOf(
        1 to listOf(3),
        2 to listOf(3),
        3 to listOf(1, 2, 5, 7),
        4 to listOf(5),
        5 to listOf(3, 4, 6, 7),
        6 to listOf(5),
        7 to listOf(3, 5),

        8 to listOf(9, 10, 11, 12),
        9 to listOf(8),
        10 to listOf(8, 12),
        11 to listOf(8),
        12 to listOf(8, 10),
    )

    val smallestConnectedComponent = SmallestConnectedComponent()

    println(smallestConnectedComponent.count(adjacencyList1))
    println(smallestConnectedComponent.count(adjacencyList2))
    println(smallestConnectedComponent.count(adjacencyList3))
}