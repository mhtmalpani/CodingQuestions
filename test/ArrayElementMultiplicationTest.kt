import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class ArrayElementMultiplicationTest {

    private inner class ArrayElementMultiplicationHelper {

        var arrayElementMultiplication = ArrayElementMultiplication()

        fun execute(data: IntArray): IntArray {
            return arrayElementMultiplication.executeWithZero(data)
        }
    }

    private lateinit var subject: ArrayElementMultiplicationHelper

    @Before
    fun setUp() {
        subject = ArrayElementMultiplicationHelper()
    }

    @Test
    fun `Sorted numbers`() {
        val data = IntArray(5) { i -> i + 1 }

        val modifiedArray = subject.execute(data)

        assertEquals(listOf(120, 60, 40, 30, 24), modifiedArray.toList())
    }

    @Test
    fun `Unsorted Numbers`() {
        val data = intArrayOf(5, 3, 8, 2, 4, 7)

        val modifiedArray = subject.execute(data)

        assertEquals(listOf(1344, 2240, 840, 3360, 1680, 960), modifiedArray.toList())
    }

    @Test
    fun `No Numbers`() {
        val data = intArrayOf()

        val modifiedArray = subject.execute(data)

        assertEquals(listOf(), modifiedArray.toList())
    }

    @Test
    fun `Single Number`() {
        val data = intArrayOf(5)

        val modifiedArray = subject.execute(data)

        assertEquals(listOf(1), modifiedArray.toList())
    }

    @Test
    fun `Numbers with one Zero`() {
        val data = intArrayOf(5, 3, 0, 2, 4, 7)

        val modifiedArray = subject.execute(data)

        assertEquals(listOf(0, 0, 840, 0, 0, 0), modifiedArray.toList())
    }

    @Test
    fun `Numbers with two Zeros`() {
        val data = intArrayOf(5, 3, 0, 2, 0, 7)

        val modifiedArray = subject.execute(data)

        assertEquals(listOf(0, 0, 0, 0, 0, 0), modifiedArray.toList())
    }
}