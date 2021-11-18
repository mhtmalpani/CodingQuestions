import org.junit.Assert

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class CanSumTest
constructor(
    private val target: Int,
    private val values: IntArray,
    private val expectedOutput: Boolean
) {

    private lateinit var canSum: CanSum

    @Before
    fun setUp() {
        canSum = CanSum()
    }

    @Test
    fun `Test Data`() {
        val result = canSum.canSumWithValues(target, values)

        Assert.assertEquals(expectedOutput, result)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf<Array<Any?>>(
            arrayOf(7, intArrayOf(1, 3, 4, 7), true),
            arrayOf(7, intArrayOf(2, 4), false),
            arrayOf(9, intArrayOf(3), true),
            arrayOf(11, intArrayOf(3), false),
            arrayOf(8, intArrayOf(2, 3, 5), true),
            arrayOf(21, intArrayOf(4, 5, 8, 2), true),
            arrayOf(300, intArrayOf(7, 14), false),
        )
    }
}