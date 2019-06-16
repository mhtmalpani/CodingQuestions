package sorting

import sorting.resources.TestsForSorting

class ShellSortTest : TestsForSorting() {

    override fun functionUnderTest(data: ArrayList<Int>): ArrayList<Int> {
        return shellSortData(data)
    }
}