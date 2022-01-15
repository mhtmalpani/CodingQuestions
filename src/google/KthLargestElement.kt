package google

import java.util.*

class KthLargestElement {

    fun getKthSmallestElement(elements: List<Int>, k: Int): Int {

        val priorityQueue = PriorityQueue<Int>()

        elements.forEach {
            priorityQueue.add(it)
        }

        for (i in 1 until k) {
            priorityQueue.poll()
        }

        return priorityQueue.poll()
    }

    fun getKthLargestElement(elements: List<Int>, k: Int): Int {

        val priorityQueue = PriorityQueue<Int>(Collections.reverseOrder())

        elements.forEach {
            priorityQueue.add(it)
        }

        for (i in 1 until k) {
            priorityQueue.poll()
        }

        return priorityQueue.poll()
    }
}

fun main() {

    val elements = listOf<Int>(3, 9, 7, 7, 2, 6, 5, 1)

    val kthLargestElement = KthLargestElement()

    println(kthLargestElement.getKthSmallestElement(elements, 1))
    println(kthLargestElement.getKthSmallestElement(elements, 2))
    println(kthLargestElement.getKthSmallestElement(elements, 3))
    println(kthLargestElement.getKthSmallestElement(elements, 4))

    println(kthLargestElement.getKthLargestElement(elements, 1))
    println(kthLargestElement.getKthLargestElement(elements, 2))
    println(kthLargestElement.getKthLargestElement(elements, 3))
    println(kthLargestElement.getKthLargestElement(elements, 4))
}