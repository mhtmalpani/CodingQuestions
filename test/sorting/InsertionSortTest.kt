package sorting

import sorting.resources.TestsForSorting

class InsertionSortTest : TestsForSorting() {

    override fun functionUnderTest(data: ArrayList<Int>): ArrayList<Int> {
        return insertionSort(data)
    }
}