package google

import kotlin.math.max

class LargestAreaOfRectangleInHistogram {

    fun getLargestArea(elements: List<Int>): Int {
        return computeLargestArea(elements)
    }

    private fun computeLargestArea(elements: List<Int>): Int {

        if (elements.isEmpty())
            return 0

        if (elements.size == 1)
            return elements.first()

        val minimumHeight = elements.minOrNull()
        val indexOfMinHeight = elements.indexOf(minimumHeight)

        var selfAreaWithThisHeight = 0

        minimumHeight?.let {
            selfAreaWithThisHeight = minimumHeight * elements.size
        }

        val lowEnd = if (indexOfMinHeight >= 1) indexOfMinHeight - 1 else 0
        val topEnd = if (indexOfMinHeight < elements.size) indexOfMinHeight + 1 else elements.size

        val maxAreaFromLeft = computeLargestArea(elements.subList(0, lowEnd))
        val maxAreaFromRight = computeLargestArea(elements.subList(topEnd, elements.size))

        return max(
            selfAreaWithThisHeight,
            max(maxAreaFromLeft, maxAreaFromRight)
        )
    }
}

fun main() {

    val largestAreaOfRectangleInHistogram = LargestAreaOfRectangleInHistogram()

    val elements = listOf<Int>(3, 2, 4, 5, 7, 6, 1, 3, 8, 9, 11, 10, 7, 5, 2, 6)

    println(largestAreaOfRectangleInHistogram.getLargestArea(elements))
}