import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class MergeSortedArraysTest {

    private lateinit var subject: MergeSortedArrays

    @Before
    fun setUp() {
        subject = MergeSortedArrays()
    }

    @Test
    fun `Merge Arrays Sorted - 1`() {
        val first = arrayListOf(1, 3, 5, 7)
        val second = arrayListOf(2, 4, 6)
        val expected = arrayListOf(1, 2, 3, 4, 5, 6, 7)

        val result = subject.mergeArraySorted(first, second)

        assertEquals(expected, result)
    }

    @Test
    fun `Merge Arrays Sorted - 2`() {
        val first = arrayListOf(1, 2, 3, 4, 5)
        val second = arrayListOf(6, 7, 8, 9)
        val expected = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

        val result = subject.mergeArraySorted(first, second)

        assertEquals(expected, result)
    }

    @Test
    fun `Merge Arrays Sorted - 3`() {
        val first = arrayListOf(2, 4, 6)
        val second = arrayListOf(1, 3, 5, 7)
        val expected = arrayListOf(1, 2, 3, 4, 5, 6, 7)

        val result = subject.mergeArraySorted(first, second)

        assertEquals(expected, result)
    }

    @Test
    fun `Merge Arrays Sorted - 4`() {
        val first = arrayListOf(6, 7, 8, 9)
        val second = arrayListOf(1, 2, 3, 4, 5)
        val expected = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

        val result = subject.mergeArraySorted(first, second)

        assertEquals(expected, result)
    }

    @Test
    fun `Merge Arrays Sorted - 5`() {
        val first = arrayListOf(2, 4, 6, 7, 8, 9)
        val second = arrayListOf(1, 2, 3, 4, 5, 7, 9, 11)
        val expected = arrayListOf(1, 2, 2, 3, 4, 4, 5, 6, 7, 7, 8, 9, 9, 11)

        val result = subject.mergeArraySorted(first, second)

        assertEquals(expected, result)
    }

    @Test
    fun `Merge Arrays Sorted - 6`() {
        val first = arrayListOf(2, 4, 6, 7, 8, 9)
        val second = arrayListOf<Int>()
        val expected = arrayListOf(2, 4, 6, 7, 8, 9)

        val result = subject.mergeArraySorted(first, second)

        assertEquals(expected, result)
    }

    @Test
    fun `Merge Arrays Sorted - 7`() {
        val first = arrayListOf<Int>()
        val second = arrayListOf(2, 4, 6, 7, 8, 9)
        val expected = arrayListOf(2, 4, 6, 7, 8, 9)

        val result = subject.mergeArraySorted(first, second)

        assertEquals(expected, result)
    }

    @Test
    fun `Merge Arrays Sorted - 8`() {
        val first = arrayListOf<Int>()
        val second = arrayListOf<Int>()
        val expected = arrayListOf<Int>()

        val result = subject.mergeArraySorted(first, second)

        assertEquals(expected, result)
    }

    @Test
    fun `Merge Arrays Sorted - 9`() {
        val first = arrayListOf(1, 2, 3, 4, 5)
        val second = arrayListOf(6, 7, 8, 9, 10)
        val expected = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        val result = subject.mergeArraySorted(first, second)

        assertEquals(expected, result)
    }


    @Test
    fun `Merge Arrays Sorted - Reversed - 1`() {
        val first = arrayListOf(1, 3, 5, 7)
        val second = arrayListOf(2, 4, 6)
        val expected = arrayListOf(7, 6, 5, 4, 3, 2, 1)

        val result = subject.mergeArraySorted(first, second, true)

        assertEquals(expected, result)
    }

    @Test
    fun `Merge Arrays Sorted - Reversed - 2`() {
        val first = arrayListOf(1, 2, 3, 4, 5)
        val second = arrayListOf(6, 7, 8, 9)
        val expected = arrayListOf(9, 8, 7, 6, 5, 4, 3, 2, 1)

        val result = subject.mergeArraySorted(first, second, true)

        assertEquals(expected, result)
    }

    @Test
    fun `Merge Arrays Sorted - Reversed - 3`() {
        val first = arrayListOf(2, 4, 6)
        val second = arrayListOf(1, 3, 5, 7)
        val expected = arrayListOf(7, 6, 5, 4, 3, 2, 1)

        val result = subject.mergeArraySorted(first, second, true)

        assertEquals(expected, result)
    }

    @Test
    fun `Merge Arrays Sorted - Reversed - 4`() {
        val first = arrayListOf(6, 7, 8, 9)
        val second = arrayListOf(1, 2, 3, 4, 5)
        val expected = arrayListOf(9, 8, 7, 6, 5, 4, 3, 2, 1)

        val result = subject.mergeArraySorted(first, second, true)

        assertEquals(expected, result)
    }

    @Test
    fun `Merge Arrays Sorted - Reversed - 5`() {
        val first = arrayListOf(2, 4, 6, 7, 8, 9)
        val second = arrayListOf(1, 2, 3, 4, 5, 7, 9, 11)
        val expected = arrayListOf(11, 9, 9, 8, 7, 7, 6, 5, 4, 4, 3, 2, 2, 1)

        val result = subject.mergeArraySorted(first, second, true)

        assertEquals(expected, result)
    }

    @Test
    fun `Merge Arrays Sorted - Reversed - 6`() {
        val first = arrayListOf(2, 4, 6, 7, 8, 9)
        val second = arrayListOf<Int>()
        val expected = arrayListOf(9, 8, 7, 6, 4, 2)

        val result = subject.mergeArraySorted(first, second, true)

        assertEquals(expected, result)
    }

    @Test
    fun `Merge Arrays Sorted - Reversed - 7`() {
        val first = arrayListOf<Int>()
        val second = arrayListOf(2, 4, 6, 7, 8, 9)
        val expected = arrayListOf(9, 8, 7, 6, 4, 2)

        val result = subject.mergeArraySorted(first, second, true)

        assertEquals(expected, result)
    }

    @Test
    fun `Merge Arrays Sorted - Reversed - 8`() {
        val first = arrayListOf<Int>()
        val second = arrayListOf<Int>()
        val expected = arrayListOf<Int>()

        val result = subject.mergeArraySorted(first, second, true)

        assertEquals(expected, result)
    }

    @Test
    fun `Merge Arrays Sorted - Reversed - 9`() {
        val first = arrayListOf(1, 2, 3, 4, 5)
        val second = arrayListOf(6, 7, 8, 9, 10)
        val expected = arrayListOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)

        val result = subject.mergeArraySorted(first, second, true)

        assertEquals(expected, result)
    }

    @Test
    fun `Merge Arrays Sorted Reversed - 9`() {
        val first = arrayListOf(1, 2, 3, 4, 5)
        val second = arrayListOf(6, 7, 8, 9, 10)
        val expected = arrayListOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)

        val result = subject.mergeArraySortedReversed(first, second)

        assertEquals(expected, result)
    }
}