package graphs

import java.util.*

class HasPath {

    fun doesHavePath(edges: ArrayList<Pair<Int, Int>>, src: Int, destination: Int): Boolean {
        val adjacencyMap = convertToHashMapAdjacency(edges)

        return bfs(adjacencyMap, src, destination)
    }

    private fun convertToHashMapAdjacency(adjacencyList: ArrayList<Pair<Int, Int>>): HashMap<Int, MutableList<Int>> {
        val hashMap: HashMap<Int, MutableList<Int>> = HashMap<Int, MutableList<Int>>()

        adjacencyList.forEach {
            if (hashMap[it.first] == null)
                hashMap[it.first] = mutableListOf<Int>()
            hashMap[it.first]?.add(it.second)
        }

        return hashMap
    }

    private fun bfs(adjacencyMap: HashMap<Int, MutableList<Int>>, src: Int, destination: Int): Boolean {
        val queue: Queue<Int> = LinkedList()
        val visited: MutableSet<Int> = mutableSetOf()
        queue.add(src)

        while (queue.size > 0) {
            val current = queue.poll()
            visited.add(current)

            if (current == destination)
                return true

            adjacencyMap[current]?.forEach { node ->
                if (!visited.contains(node))
                    queue.add(node)
            }
        }

        return false
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
        Pair(5, 7),
        Pair(7, 5),
        Pair(8, 9),
        Pair(8, 10),
        Pair(8, 11),
        Pair(9, 12),
    )

    val hasPath = HasPath()

    println(hasPath.doesHavePath(edges, 1, 6))
    println(hasPath.doesHavePath(edges, 1, 8))
    println(hasPath.doesHavePath(edges, 8, 12))
    println(hasPath.doesHavePath(edges, 1, 8))
}