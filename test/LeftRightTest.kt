import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.assertEquals

@RunWith(Parameterized::class)
class LeftRightTest
constructor(
        private val testData: Array<Int>,
        private val expectedOutput: List<Int>
) {

    private lateinit var leftRight: LeftRight

    @Before
    fun setUp() {
        leftRight = LeftRight()
    }

    @Test
    fun `Test Data`() {
        val result = leftRight.compute(testData)

        assertEquals(expectedOutput.toString(), result.toString())
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf<Array<Any?>>(
                arrayOf(arrayOf(1, 3, 5, 7, 9, 11, 15, 13), listOf(9, 7, 5, 3, 1, 11, 15, 13)),
                arrayOf(arrayOf(2, 4, 6, 8, 4, 12, 10, 18, 16), listOf(4, 12, 10, 18, 16, 8, 6, 4, 2)),
                arrayOf(arrayOf(7, 5, 2, 3, 4, 8, 1, 6, 9), listOf(4, 8, 1, 3, 2, 6, 9, 5, 7)),
                arrayOf(arrayOf(3, 9, 7, 6, 4, 5, 1, 2, 8), listOf(4, 5, 6, 1, 7, 9, 3, 2, 8)),
                arrayOf(arrayOf(9, 7, 5, 3, 1, 2, 4, 7, 8, 6), listOf(2, 4, 7, 1, 3, 5, 7, 9, 8, 6)),
                arrayOf(arrayOf(9, 3, 6, 8), listOf(6, 8, 3, 9)),
                arrayOf(arrayOf(9, 7, 5), listOf(7, 9, 5)),
                arrayOf(arrayOf(1, 2, 3), listOf(2, 3, 1)),
                arrayOf(arrayOf(1, 2), listOf(2, 1)),
                arrayOf(arrayOf(1), listOf(1)),
                arrayOf(arrayOf(2), listOf(2))
        )
    }
}