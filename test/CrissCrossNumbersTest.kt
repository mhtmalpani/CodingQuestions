import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CrissCrossNumbersTest {

    private lateinit var crissCrossNumbers: CrissCrossNumbers

    @Before
    fun setUp() {
        crissCrossNumbers = CrissCrossNumbers()
    }

    @Test
    fun `Criss Cross - Simple - 1`() {

        val data = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8)

        val result = crissCrossNumbers.execute(data)

        assertEquals(arrayListOf(5, 4, 6, 3, 7, 2, 8, 1), result)
    }

    @Test
    fun `Criss Cross - Simple - 2`() {

        val data = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

        val result = crissCrossNumbers.execute(data)

        assertEquals(arrayListOf(5, 4, 6, 3, 7, 2, 8, 1, 9), result)
    }

    @Test
    fun `Criss Cross - Repeating - 1`() {

        val data = arrayListOf(1, 2, 3, 3, 5, 6, 6, 6, 9)

        val result = crissCrossNumbers.execute(data)

        assertEquals(arrayListOf(5, 3, 6, 3, 6, 2, 6, 1, 9), result)
    }

    @Test
    fun `Criss Cross - Repeating - unsorted 1 - Odd size`() {

        //Sorted: 1, 2, 4, 5, 7, 9, 12, 25, 30
        val data = arrayListOf(5, 2, 30, 4, 12, 9, 1, 7, 25)

        val result = crissCrossNumbers.execute(data)

        assertEquals(arrayListOf(7, 5, 9, 4, 12, 2, 25, 1, 30), result)
    }

    @Test
    fun `Criss Cross - Repeating - unsorted 2 - Even size`() {

        //Sorted: 1, 2, 4, 5, 7, 9, 12, 23, 25, 30
        val data = arrayListOf(5, 2, 30, 4, 12, 9, 1, 7, 25, 23)

        val result = crissCrossNumbers.execute(data)

        assertEquals(arrayListOf(9, 7, 12, 5, 23, 4, 25, 2, 30, 1), result)
    }

    @Test
    fun `Criss Cross - One element`() {

        val data = arrayListOf(7)

        val result = crissCrossNumbers.execute(data)

        assertEquals(arrayListOf(7), result)
    }
}