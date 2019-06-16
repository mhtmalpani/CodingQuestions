package sorting

import sorting.resources.TestsForSorting

class BubbleSortImprovisedTest : TestsForSorting() {

    override fun functionUnderTest(data: ArrayList<Int>): ArrayList<Int> {
        return bubbleSortImprovised(data)
    }
}