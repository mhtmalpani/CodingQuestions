package sorting.resources

import org.junit.Test
import kotlin.test.assertEquals


abstract class TestsForSorting {

    abstract fun functionUnderTest(data: ArrayList<Int>): ArrayList<Int>

    @Test
    fun `Data Set 0`() {
        assertEquals(
                getSortedData(0),
                functionUnderTest(getDataSetForSorting(0))
        )
    }

    @Test
    fun `Data Set 1`() {
        assertEquals(
                getSortedData(1),
                functionUnderTest(getDataSetForSorting(1))
        )
    }

    @Test
    fun `Data Set 2`() {
        assertEquals(
                getSortedData(2),
                functionUnderTest(getDataSetForSorting(2))
        )
    }

    @Test
    fun `Data Set 3`() {
        assertEquals(
                getSortedData(3),
                functionUnderTest(getDataSetForSorting(3))
        )
    }

    @Test
    fun `Data Set 4`() {
        assertEquals(
                getSortedData(4),
                functionUnderTest(getDataSetForSorting(4))
        )
    }

    @Test
    fun `Data Set 5`() {
        assertEquals(
                getSortedData(5),
                functionUnderTest(getDataSetForSorting(5))
        )
    }

    @Test
    fun `Data Set 6`() {
        assertEquals(
                getSortedData(6),
                functionUnderTest(getDataSetForSorting(6))
        )
    }

    @Test
    fun `Data Set 7`() {
        assertEquals(
                getSortedData(7),
                functionUnderTest(getDataSetForSorting(7))
        )
    }

    @Test
    fun `Data Set 8`() {
        assertEquals(
                getSortedData(8),
                functionUnderTest(getDataSetForSorting(8))
        )
    }

    @Test
    fun `Data Set 9`() {
        assertEquals(
                getSortedData(9),
                functionUnderTest(getDataSetForSorting(9))
        )
    }
}