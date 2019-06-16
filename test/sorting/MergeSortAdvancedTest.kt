package sorting

import sorting.resources.TestsForSorting

class MergeSortAdvancedTest : TestsForSorting() {

    override fun functionUnderTest(data: ArrayList<Int>): ArrayList<Int> {
        return mergeSortDataAdvanced(data)
    }
}