package sorting

import sorting.resources.TestsForSorting

class SelectionSortTest : TestsForSorting() {

    override fun functionUnderTest(data: ArrayList<Int>): ArrayList<Int> {
        return selectionSort(data)
    }
}