package graphs

import java.util.*

class BFS {

    fun bfsIterative(edges: ArrayList<Pair<Int, Int>>, startNode: Int): List<Int> {

        val adjacencyList = convertToHashMapAdjacency(edges)

        val queue: Queue<Int> = LinkedList()
        val bfsList: MutableList<Int> = mutableListOf()

        queue.add(startNode)

        while (queue.isNotEmpty()) {
            val current = queue.poll()
            bfsList.add(current)

            adjacencyList[current]?.forEach { neighbor ->
                if (!queue.contains(neighbor))
                    queue.add(neighbor)
            }
        }

        return bfsList
    }

    fun bfsRecursive(edges: ArrayList<Pair<Int, Int>>, startNode: Int): List<Int> {

        val adjacencyList = convertToHashMapAdjacency(edges)

        val visited: MutableSet<Int> = mutableSetOf()
        val bfsList: MutableList<Int> = mutableListOf()
        val queue: Queue<Int> = ArrayDeque()

        queue.add(startNode)

        explore(adjacencyList, visited, bfsList, queue)

        return bfsList
    }

    private fun explore(
        adjacencyList: HashMap<Int, MutableList<Int>>,
        visited: MutableSet<Int>,
        bfsList: MutableList<Int>,
        queue: Queue<Int>
    ) {

        if (queue.isEmpty())
            return

        val current = queue.poll()
        bfsList.add(current)

        adjacencyList[current]?.forEach { neighbor ->
            if (!visited.contains(neighbor)) {
                visited.add(neighbor)
                queue.add(neighbor)
            }
        }

        explore(adjacencyList, visited, bfsList, queue)
    }

    private fun convertToHashMapAdjacency(edges: ArrayList<Pair<Int, Int>>): HashMap<Int, MutableList<Int>> {
        val hashMap: HashMap<Int, MutableList<Int>> = HashMap()

        edges.forEach {
            if (hashMap[it.first] == null)
                hashMap[it.first] = mutableListOf()
            hashMap[it.first]?.add(it.second)
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
        Pair(7, 8),
        Pair(7, 9),
        Pair(7, 10),
        Pair(7, 11),
        Pair(8, 11),
        Pair(9, 12),
    )

    val bfs = BFS()

    val bfsListIterative = bfs.bfsIterative(edges, 1)

    bfsListIterative.forEach {
        print("$it ")
    }

    println()

    val bfsListRecursive = bfs.bfsRecursive(edges, 1)

    bfsListRecursive.forEach {
        print("$it ")
    }
}