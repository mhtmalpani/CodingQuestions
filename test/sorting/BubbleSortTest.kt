package sorting

import sorting.resources.TestsForSorting

class BubbleSortTest : TestsForSorting() {

    override fun functionUnderTest(data: ArrayList<Int>): ArrayList<Int> {
        return bubbleSort(data)
    }
}