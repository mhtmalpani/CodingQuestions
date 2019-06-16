package sorting

import sorting.resources.TestsForSorting

class QuickSortTest : TestsForSorting() {

    override fun functionUnderTest(data: ArrayList<Int>): ArrayList<Int> {
        return quickSortData(data)
    }
}