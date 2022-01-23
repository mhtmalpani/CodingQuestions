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

    fun getKthSmallestElementWithFixPQ(elements: List<Int>, k: Int): Int {

        val priorityQueue = PriorityQueue<Int>(Collections.reverseOrder())

        for (i in 0 until k) {
            priorityQueue.add(elements[i])
        }

        for (i in k until elements.size) {
            if (elements[i] < priorityQueue.peek()) {
                priorityQueue.poll()
                priorityQueue.add(elements[i])
            }
        }

        return priorityQueue.poll()
    }

    fun getKthLargestElementWithFixPQ(elements: List<Int>, k: Int): Int {

        val priorityQueue = PriorityQueue<Int>()

        for (i in 0 until k) {
            priorityQueue.add(elements[i])
        }

        for (i in k until elements.size) {
            if (elements[i] > priorityQueue.peek()) {
                priorityQueue.poll()
                priorityQueue.add(elements[i])
            }
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

    println("Smallest without PQ")

    println(kthLargestElement.getKthSmallestElement(elements, 1))
    println(kthLargestElement.getKthSmallestElement(elements, 2))
    println(kthLargestElement.getKthSmallestElement(elements, 3))
    println(kthLargestElement.getKthSmallestElement(elements, 4))

    println("Smallest with PQ")

    println(kthLargestElement.getKthSmallestElementWithFixPQ(elements, 1))
    println(kthLargestElement.getKthSmallestElementWithFixPQ(elements, 2))
    println(kthLargestElement.getKthSmallestElementWithFixPQ(elements, 3))
    println(kthLargestElement.getKthSmallestElementWithFixPQ(elements, 4))

    println("Largest without PQ")

    println(kthLargestElement.getKthLargestElement(elements, 1))
    println(kthLargestElement.getKthLargestElement(elements, 2))
    println(kthLargestElement.getKthLargestElement(elements, 3))
    println(kthLargestElement.getKthLargestElement(elements, 4))

    println("Largest with PQ")

    println(kthLargestElement.getKthLargestElementWithFixPQ(elements, 1))
    println(kthLargestElement.getKthLargestElementWithFixPQ(elements, 2))
    println(kthLargestElement.getKthLargestElementWithFixPQ(elements, 3))
    println(kthLargestElement.getKthLargestElementWithFixPQ(elements, 4))
}