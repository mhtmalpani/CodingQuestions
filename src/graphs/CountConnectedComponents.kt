package graphs

class CountConnectedComponents {

    fun countIslands(edges: ArrayList<Pair<Int, Int>>): Int {
        val adjacencyMap = convertToHashMapAdjacency(edges)

        var count = 0
        val visited: MutableSet<Int> = mutableSetOf()

        adjacencyMap.forEach {
            if (explore(adjacencyMap, it.key, visited))
                count++
        }

        return count
    }

    private fun explore(
        adjacencyMap: HashMap<Int, MutableList<Int>>,
        node: Int,
        visited: MutableSet<Int>
    ): Boolean {
        if (visited.contains(node))
            return false

        visited.add(node)

        adjacencyMap[node]?.forEach {
            explore(adjacencyMap, it, visited)
        }

        return true
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

    val countConnectedComponents = CountConnectedComponents()

    println(countConnectedComponents.countIslands(edges))
}