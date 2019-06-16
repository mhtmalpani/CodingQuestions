package sorting

import org.junit.Test
import sorting.resources.TestsForSorting
import kotlin.test.assertEquals

class QuickSortGenericTest : TestsForSorting() {

    override fun functionUnderTest(data: ArrayList<Int>): ArrayList<Int> {
        return quickSortDataGeneric(data)
    }

    @Test
    fun `String Data 0`() {
        assertEquals(
                arrayListOf('a', 'b', 'c', 'd', 'e', 'f'),
                quickSortDataGeneric(arrayListOf('b', 'd', 'a', 'f', 'c', 'e'))
        )
    }

    @Test
    fun `Floating Data 0`() {
        assertEquals(
                arrayListOf(3.56, 9.123, 23.0, 44.44, 67.2, 78.34, 94.75, 976.0),
                quickSortDataGeneric(arrayListOf(3.56, 9.123, 78.34, 44.44, 23.00, 976.0, 94.75, 67.20))
        )
    }
}