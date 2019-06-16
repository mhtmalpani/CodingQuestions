package sorting

import sorting.resources.TestsForSorting

class MergeSortTest : TestsForSorting() {

    override fun functionUnderTest(data: ArrayList<Int>): ArrayList<Int> {
        return mergeSortData(data)
    }
}