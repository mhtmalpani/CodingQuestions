import org.junit.Assert

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class HowSumTest
constructor(
    private val target: Int,
    private val values: IntArray,
    private val expectedOutput: List<Int>?
) {

    private lateinit var howSum: HowSum

    @Before
    fun setUp() {
        howSum = HowSum()
    }

    @Test
    fun `Test Data`() {
        val result = howSum.howSumWithValues(target, values)

        Assert.assertEquals(expectedOutput, result)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf<Array<Any?>>(
            arrayOf(7, intArrayOf(2, 3, 4, 7), listOf(3, 2, 2)),
            arrayOf(7, intArrayOf(2, 4), null),
            arrayOf(9, intArrayOf(3), listOf(3, 3, 3)),
            arrayOf(11, intArrayOf(3), null),
            arrayOf(8, intArrayOf(2, 3, 5), listOf(2, 2, 2, 2)),
            arrayOf(21, intArrayOf(4, 5, 8, 2), listOf(0)),
            arrayOf(300, intArrayOf(7, 14), null),
            arrayOf(900, intArrayOf(7, 14), null),
        )
    }
}