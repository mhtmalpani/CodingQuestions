package graphs

import java.util.*

class DFS {

    fun dfsIterative(edges: ArrayList<Pair<Int, Int>>, startNode: Int): List<Int> {

        val adjacencyList = convertToHashMapAdjacency(edges)

        val stack: Stack<Int> = Stack()
        val visited: MutableSet<Int> = mutableSetOf()
        val dfsList: MutableList<Int> = mutableListOf()

        stack.push(startNode)

        while (stack.isNotEmpty()) {
            val current = stack.pop()
            dfsList.add(current)
            visited.add(current)

            adjacencyList[current]?.forEach { neighbor ->
                if (!visited.contains(neighbor))
                    stack.add(neighbor)
            }
        }

        return dfsList
    }

    fun dfsRecursive(edges: ArrayList<Pair<Int, Int>>, startNode: Int): List<Int> {

        val adjacencyList = convertToHashMapAdjacency(edges)

        val visited: MutableSet<Int> = mutableSetOf()
        val dfsList: MutableList<Int> = mutableListOf()

        explore(adjacencyList, startNode, visited, dfsList)

        return dfsList
    }

    private fun explore(
        adjacencyList: HashMap<Int, MutableList<Int>>,
        current: Int,
        visited: MutableSet<Int>,
        dfsList: MutableList<Int>
    ) {

        if (visited.contains(current))
            return

        dfsList.add(current)
        visited.add(current)

        adjacencyList[current]?.forEach { neighbor ->
            explore(adjacencyList, neighbor, visited, dfsList)
        }

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

    val dfs = DFS()

    val dfsListIterative = dfs.dfsIterative(edges, 1)

    dfsListIterative.forEach {
        print("$it ")
    }

    println()

    val dfsListRecursive = dfs.dfsRecursive(edges, 1)

    dfsListRecursive.forEach {
        print("$it ")
    }
}