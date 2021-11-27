package graphs

class LargestConnectedComponent {

    fun count(edges: ArrayList<Pair<Int, Int>>): Int {
        val adjacencyMap = convertToHashMapAdjacency(edges)

        var largestSize = -1
        val visited: MutableSet<Int> = mutableSetOf()

        adjacencyMap.forEach {
            val size = explore(adjacencyMap, it.key, visited)
            if (size > largestSize)
                largestSize = size
        }

        return largestSize
    }

    private fun explore(
        adjacencyMap: HashMap<Int, MutableList<Int>>,
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

    private fun convertToHashMapAdjacency(adjacencyList: ArrayList<Pair<Int, Int>>): HashMap<Int, MutableList<Int>> {
        val hashMap: HashMap<Int, MutableList<Int>> = HashMap()

        //Create Dual adjacency for Undirected Graph

        adjacencyList.forEach {
            if (hashMap[it.first] == null)
                hashMap[it.first] = mutableListOf()
            if (hashMap[it.second] == null)
                hashMap[it.second] = mutableListOf()
            hashMap[it.first]?.add(it.second)
            hashMap[it.second]?.add(it.first)
        }

        return hashMap
    }
}

fun main() {
    val edges: ArrayList<Pair<Int, Int>> = arrayListOf(
        Pair(1, 3),
        Pair(2, 3),
        Pair(3, 5),
        Pair(3, 7),
        Pair(5, 6),
        Pair(5, 7),

        Pair(8, 9),
        Pair(8, 10),
        Pair(8, 11),
        Pair(9, 12),

        Pair(13, 14),
    )

    val largestConnectedComponent = LargestConnectedComponent()

    println(largestConnectedComponent.count(edges))
}